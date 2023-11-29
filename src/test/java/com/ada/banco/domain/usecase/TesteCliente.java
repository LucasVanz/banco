package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.repository.ClienteRepository;
import com.ada.banco.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TesteCliente {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void listarTodosDeveRetornarListaDeClientes() {
        Cliente cliente1 = new Cliente(1L, "Cliente1", "12345678901");
        Cliente cliente2 = new Cliente(2L, "Cliente2", "98765432109");
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        Mockito.when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.listarTodos();

        assertEquals(clientes, result);
    }

    @Test
    void buscarPorCpfDeveRetornarClienteQuandoEncontrado() {
        String cpf = "12345678901";
        Cliente cliente = new Cliente(1L, "Cliente1", cpf);

        Mockito.when(clienteRepository.findByCpf(cpf)).thenReturn(cliente);

        Cliente result = clienteService.buscarPorCpf(cpf);

        assertEquals(cliente, result);
    }

    @Test
    void buscarPorCpfDeveLancarExcecaoQuandoNaoEncontrado() {
        String cpf = "12345678901";

        Mockito.when(clienteRepository.findByCpf(cpf)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> clienteService.buscarPorCpf(cpf));
    }

    @Test
    void salvarDeveSalvarClienteQuandoCpfNaoExiste() {
        Cliente cliente = new Cliente(null, "NovoCliente", "12345678901");

        Mockito.when(clienteRepository.findByCpf(cliente.getCpf())).thenReturn(null);
        Mockito.when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente result = clienteService.salvar(cliente);

        assertEquals(cliente, result);
    }

    @Test
    void salvarDeveLancarExcecaoQuandoCpfJaExiste() {
        Cliente cliente = new Cliente(1L, "ClienteExistente", "12345678901");

        Mockito.when(clienteRepository.findByCpf(cliente.getCpf())).thenReturn(cliente);

        assertThrows(RuntimeException.class, () -> clienteService.salvar(cliente));
    }

    @Test
    void excluirDeveExcluirClienteQuandoEncontrado() {
        String cpf = "12345678901";

        Mockito.when(clienteRepository.findByCpf(cpf)).thenReturn(new Cliente());

        clienteService.excluir(cpf);

        Mockito.verify(clienteRepository, Mockito.times(1)).deleteByCpf(cpf);
    }

    @Test
    void excluirDeveLancarExcecaoQuandoClienteNaoEncontrado() {
        String cpf = "12345678901";

        Mockito.when(clienteRepository.findByCpf(cpf)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> clienteService.excluir(cpf));
    }
}
