package com.ada.banco.infra.controller;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.DadosCadastroConta;
import com.ada.banco.service.ClienteService;
import com.ada.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/contas")
public class ContaController {

    ContaService contaService;
    ClienteService clienteService;


    public ContaController(ContaService contaService, ClienteService clienteService) {
        this.contaService = contaService;
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Conta> criarConta(@RequestBody DadosCadastroConta dadosCadastro) {
        Conta conta = new Conta();
        try {
            conta.setAgencia(dadosCadastro.getAgencia());
            conta.setDigito(dadosCadastro.getDigito());
            conta.setSaldo(dadosCadastro.getSaldo());
            conta.setCliente(clienteService.buscarPorCpf(dadosCadastro.getCpf()));
            return new ResponseEntity<>(contaService.salvar(conta), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todas")
    public List<Conta> getContas(){return contaService.listarTodas();}
}
