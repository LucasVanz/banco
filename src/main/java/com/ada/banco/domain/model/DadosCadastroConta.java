package com.ada.banco.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosCadastroConta {
    private Long agencia;
    private Long digito;
    private BigDecimal saldo;
    private String cpf;

    // Getters e setters
}