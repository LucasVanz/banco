package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.repository.ClienteRepository;
import com.ada.banco.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void listarTodosDeveRetornarListaVaziaQuandoNaoHouverClientes() {
        when(clienteRepository.findAll()).thenReturn(Collections.emptyList());

        List<Cliente> clientes = clienteService.listarTodos();

        assertTrue(clientes.isEmpty());
    }

    @Test
    void listarTodosDeveRetornarListaDeClientesQuandoHouverClientes() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678901");
        when(clienteRepository.findAll()).thenReturn(Collections.singletonList(cliente));

        List<Cliente> clientes = clienteService.listarTodos();

        assertEquals(1, clientes.size());
        assertEquals(cliente, clientes.get(0));
    }

    @Test
    void buscarPorCpfDeveRetornarClienteQuandoExistir() {
        Cliente cliente = new Cliente(1L, "Nome", "12345678901");
        when(clienteRepository.findByCpf("12345678901")).thenReturn(cliente);

        Cliente clienteEncontrado = clienteService.buscarPorCpf("12345678901");

        assertNotNull(clienteEncontrado);
        assertEquals(cliente, clienteEncontrado);
    }

    @Test
    void buscarPorCpfDeveLancarExcecaoQuandoNaoExistirCliente() {
        when(clienteRepository.findByCpf("12345678901")).thenReturn(null);

        assertThrows(RuntimeException.class, () -> clienteService.buscarPorCpf("12345678901"));
    }


    @Test
    void salvarDeveLancarExcecaoQuandoExistirClienteComMesmoCpf() {
        when(clienteRepository.findByCpf("12345678901")).thenReturn(new Cliente());

        Cliente cliente = new Cliente(1L, "Nome", "12345678901");

        assertThrows(RuntimeException.class, () -> clienteService.salvar(cliente));
    }

    @Test
    void excluirDeveLancarExcecaoQuandoNaoExistirCliente() {
        when(clienteRepository.findByCpf("12345678901")).thenReturn(null);

        assertThrows(RuntimeException.class, () -> clienteService.excluir("12345678901"));
    }

    @Test
    void excluirDeveChamarMetodoDeleteByCpfDoRepositorioQuandoExistirCliente() {
        when(clienteRepository.findByCpf("12345678901")).thenReturn(new Cliente());

        clienteService.excluir("12345678901");

        verify(clienteRepository, times(1)).deleteByCpf("12345678901");
    }
}