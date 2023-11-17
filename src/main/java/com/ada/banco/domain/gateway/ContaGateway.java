package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Conta;

public interface ContaGateway {
    Conta buscarCpf(String cpf);
    Conta salvar(Conta conta);
}
