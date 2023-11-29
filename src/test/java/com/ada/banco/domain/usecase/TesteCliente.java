package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.infra.controller.ClienteController;
import com.ada.banco.repository.ClienteRepository;
import com.ada.banco.repository.ContaRepository;
import com.ada.banco.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TesteCliente {
    @Mock
    ClienteRepository clienteRepository;
    @InjectMocks
    ClienteService clienteService = new ClienteService(clienteRepository);

    @Test
    public void deveSalvarUmCliente(){
        String cpf = "1234";
        String nome = "lucas";
        Cliente cliente = new Cliente(1L, nome, cpf);

        Mockito.when(clienteService.salvar(cliente)).thenReturn(cliente);
    }
}
