package com.ada.banco.service;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.repository.ClienteRepository;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService{
    ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorCpf(String cpf) {
        if (clienteRepository.findByCpf(cpf) == null){
            throw new RuntimeException("Não foi encontrado nenhum cliente com esse CPF");
        }
        return clienteRepository.findByCpf(cpf);
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente.getCpf() != null && clienteRepository.findByCpf(cliente.getCpf()) != null) {
            throw new RuntimeException("Já existe um cliente com esse CPF");
        }

        return clienteRepository.save(cliente);
    }

    public void excluir(String cpf) {
        if (clienteRepository.findByCpf(cpf) == null) {
            throw new RuntimeException("Cliente não encontrado.");
        }

        clienteRepository.deleteByCpf(cpf);
    }
}

