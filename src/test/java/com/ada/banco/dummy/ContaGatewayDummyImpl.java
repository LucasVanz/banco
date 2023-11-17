package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaGatewayDummyImpl implements ContaGateway {

    @Override
    public Conta buscarCpf(String cpf) {
        if (Objects.equals(cpf, "123456789")) {
            return new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Lucas", "123456789");
        }
        return null;
    }

    @Override
    public Conta salvar(Conta conta) {
        return new Conta(12345L, 0002L,1L, BigDecimal.valueOf(10000),"Thiago", "987654321");
    }
}
