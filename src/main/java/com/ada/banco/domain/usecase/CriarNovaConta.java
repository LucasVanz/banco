package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

public class CriarNovaConta {
    private ContaGateway contaGateway;

    public CriarNovaConta(ContaGateway contaGateway) {
        this.contaGateway = contaGateway;
    }

    public Conta execute(Conta conta) throws Exception{
        if (contaGateway.buscarCpf(conta.getCliente().getCpf()) != null){
            throw new Exception("Usuário já possui conta");
        }else {
            return conta;
        }
    }
}
