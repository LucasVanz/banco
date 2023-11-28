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
public class Transferencia {
    private String cpfOrigem;
    private String cpfDestino;
    private BigDecimal quantiaTransferencia;
}
