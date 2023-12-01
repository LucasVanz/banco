package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.DadosCadastroConta;
import com.ada.banco.repository.ContaRepository;
import com.ada.banco.service.ClienteService;
import com.ada.banco.service.ContaService;
import com.ada.banco.infra.controller.ContaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TesteConta {

    @InjectMocks
    private ContaController contaController;

    @Mock
    private ContaService contaService;

    @Mock
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarConta() {
        DadosCadastroConta dadosCadastro = new DadosCadastroConta();
        dadosCadastro.setAgencia(123L);
        dadosCadastro.setDigito(1L);
        dadosCadastro.setSaldo(BigDecimal.ZERO);
        dadosCadastro.setCpf("12345678901");

        Conta conta = new Conta();
        conta.setAgencia(dadosCadastro.getAgencia());
        conta.setDigito(dadosCadastro.getDigito());
        conta.setSaldo(dadosCadastro.getSaldo());

        when(clienteService.buscarPorCpf(dadosCadastro.getCpf())).thenReturn(new Cliente());
        when(contaService.salvar(any(Conta.class))).thenReturn(conta);

        ResponseEntity<Conta> responseEntity = contaController.criarConta(dadosCadastro);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(conta, responseEntity.getBody());

        verify(clienteService, times(1)).buscarPorCpf(dadosCadastro.getCpf());
        verify(contaService, times(1)).salvar(any(Conta.class));
    }

    @Test
    void testCriarContaException() {
        DadosCadastroConta dadosCadastro = new DadosCadastroConta();
        dadosCadastro.setAgencia(123L);
        dadosCadastro.setDigito(1L);
        dadosCadastro.setSaldo(BigDecimal.ZERO);
        dadosCadastro.setCpf("12345678901");

        when(clienteService.buscarPorCpf(dadosCadastro.getCpf())).thenThrow(new RuntimeException("Test Exception"));

        ResponseEntity<Conta> responseEntity = contaController.criarConta(dadosCadastro);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    void testGetContas() {
        List<Conta> contas = new ArrayList<>();
        when(contaService.listarTodas()).thenReturn(contas);

        List<Conta> result = contaController.getContas();

        assertEquals(contas, result);
        verify(contaService, times(1)).listarTodas();
    }
}

