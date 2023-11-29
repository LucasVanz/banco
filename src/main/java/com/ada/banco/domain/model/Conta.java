package com.ada.banco.domain.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "agencia", nullable = false)
    private Long agencia;
    @Column(name = "digito", nullable = false)
    private Long digito;
    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;
    @OneToOne
    private Cliente cliente;


}
