package com.ada.banco.service;

import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Deposito;

import com.ada.banco.domain.model.Saque;
import com.ada.banco.domain.model.Transferencia;
import com.ada.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MovimentoService {
    ContaRepository contaRepository;

    public MovimentoService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Deposito depositar(Deposito deposito){
        Conta conta = contaRepository.findByCliente_Cpf(deposito.getCpfDestino());
        conta.setSaldo(conta.getSaldo().add(deposito.getQuantiaDeposito()));
        contaRepository.save(conta);
        return deposito;
    }

    public Saque sacar(Saque saque){
        Conta conta = contaRepository.findByCliente_Cpf(saque.getCpfOrigem());
        if (conta.getSaldo().compareTo(saque.getQuantiaSaque()) <= 0){
            throw new RuntimeException("Quantia de saque maior que o saldo da conta");
        }
        conta.setSaldo(conta.getSaldo().subtract(saque.getQuantiaSaque()));
        return saque;
    }

    public Transferencia transferencia(Transferencia transferencia){
        Conta contaDestino = contaRepository.findByCliente_Cpf(transferencia.getCpfDestino());
        Conta contaOrigem = contaRepository.findByCliente_Cpf(transferencia.getCpfDestino());
        if(contaOrigem.getSaldo().compareTo(transferencia.getQuantiaTransferencia()) <= 0){
            throw new RuntimeException("Quantia inválida para transferência");
        }
        contaDestino.setSaldo(contaDestino.getSaldo().add(transferencia.getQuantiaTransferencia()));
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(transferencia.getQuantiaTransferencia()));
        return transferencia;
    }
}
