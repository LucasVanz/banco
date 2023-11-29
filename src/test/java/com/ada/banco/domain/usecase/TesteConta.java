package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Conta;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteConta {
    @Test
    public void testGetterAndSetter() {
        Conta conta = new Conta();
        conta.setId(1L);
        conta.setAgencia(123L);
        conta.setDigito(1L);
        conta.setSaldo(new BigDecimal("100.00"));
        // Você pode adicionar mais propriedades e testar outros setters conforme necessário

        assertEquals(1L, conta.getId());
        assertEquals(123L, conta.getAgencia());
        assertEquals(1L, conta.getDigito());
        assertEquals(new BigDecimal("100.00"), conta.getSaldo());
        // Adicione mais verificações conforme necessário

    }

    @Test
    public void testConstructor() {
        // Teste o construtor padrão e o construtor com parâmetros, se aplicável
        Conta conta = new Conta();
        // Verifique se os valores padrão estão corretos, se houver algum
        // Você pode adicionar mais verificações conforme necessário
    }

    // Adicione mais testes para outros métodos e lógica de negócios conforme necessário

}

