package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

public class CriarNovaConta {
    private ContaGateway contaGateway;

    public CriarNovaConta(ContaGateway contaGateway) {
        this.contaGateway = contaGateway;
    }

    public Conta execute(Conta conta) throws Exception{
        if (contaGateway.buscarCpf(conta.getCpf()) != null){
            throw new Exception("usuário já possui conta");
        }

        return contaGateway.salvar(conta);

    }
}
