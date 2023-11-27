package com.ada.banco.repository;

import com.ada.banco.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);

    void deleteByCpf(String cpf);
}
