package com.ada.banco.service;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {
    ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> listarTodas() {
        return contaRepository.findAll();
    }

    public Conta buscarPorCpf(String cpf) {
        if (contaRepository.findByCliente_Cpf(cpf) == null){
            throw new RuntimeException("Não foi encontrado nenhuma conta nesse CPF");
        }
        return contaRepository.findByCliente_Cpf(cpf);
    }

    public Conta salvar(Conta conta) {
        if (contaRepository.findByCliente_Cpf(conta.getCliente().getCpf()) != null) {
            throw new RuntimeException("Já existe uma conta nesse CPF");
        }

        return contaRepository.save(conta);
    }

    public void excluir(String cpf) {
        if (contaRepository.findByCliente_Cpf(cpf) == null) {
            throw new RuntimeException("Conta não encontrada.");
        }
        contaRepository.deleteByCliente_cpf(cpf);
    }
}
