package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaGatewayDummyImpl implements ContaGateway {

    @Override
    public Conta buscarCpf(String cpf) {
//        Cliente cliente = new Cliente(1L, "Lucas","123456789");
//        if (Objects.equals(cpf, "123456789")) {
//            return new Conta(12345L, cliente, 0002L, 1L, BigDecimal.ZERO);
//        }
        return null;
    }
    @Override
    public Conta salvar(Conta conta) {
//        Cliente cliente = new Cliente(1L, "Thiago", "987654321");
//        return new Conta(12345L, cliente, 0002L,1L, BigDecimal.valueOf(10000));
        return null;
    }
}
