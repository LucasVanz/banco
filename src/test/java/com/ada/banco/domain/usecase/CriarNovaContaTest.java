package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.dummy.ContaGatewayDummyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CriarNovaContaTest {
//    @Test
//    public void deveLancarUmaExceptionCasoUsuariojaPossuaUmaConta(){
//        //given
//        ContaGateway contaGateway = new ContaGatewayDummyImpl();
//        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
//        Cliente cliente = new Cliente(1L, "Lucas","123456789");
//        Conta conta = new Conta(12345L, cliente,2L,1L, BigDecimal.ZERO);
//
//        //when
////        criarNovaConta.execute(conta);
//        Assertions.assertThrows(Exception.class, () -> criarNovaConta.execute(conta));
//
//
//    }
//    @Test
//    public void deveCriarUmaContaComSucesso() throws Exception {
//        //given
//        ContaGateway contaGateway = new ContaGatewayDummyImpl();
//        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
//        Cliente cliente = new Cliente(1L, "Thiago", "987654321");
//        Conta conta = new Conta(12345L,cliente , 0002L,1L, BigDecimal.valueOf(10000));
//
//        //when
//        Conta novaConta = criarNovaConta.execute(conta);
//        Assertions.assertAll(() -> Assertions.assertEquals("Thiago", novaConta.getCliente().getNome()),
//                             () -> Assertions.assertEquals("987654321", novaConta.getCliente().getCpf()));
//
//
//    }

//
}
