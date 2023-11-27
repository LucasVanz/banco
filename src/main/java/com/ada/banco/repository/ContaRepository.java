package com.ada.banco.repository;

import com.ada.banco.domain.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta findByCliente_Cpf(String cpf);

    void deleteByCliente_cpf(String cpf);
}
