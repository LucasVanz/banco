package com.ada.banco.infra.controller;

import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Deposito;
import com.ada.banco.domain.model.Saque;
import com.ada.banco.domain.model.Transferencia;
import com.ada.banco.service.MovimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/movimento")
public class MovimentoController {
    MovimentoService movimentoService;

    public MovimentoController(MovimentoService movimentoService) {
        this.movimentoService = movimentoService;
    }
    @PostMapping("/deposito")
    public ResponseEntity<Deposito> depositar(@RequestBody Deposito deposito){
        try {
            return new ResponseEntity<>(movimentoService.depositar(deposito), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sacar")
    public ResponseEntity<Saque> sacar(@RequestBody Saque saque){
        try {
            return new ResponseEntity<>(movimentoService.sacar(saque), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/transferir")
    public ResponseEntity<Transferencia> transferir(@RequestBody Transferencia transferencia){
        try {
            return new ResponseEntity<>(movimentoService.transferencia(transferencia), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
