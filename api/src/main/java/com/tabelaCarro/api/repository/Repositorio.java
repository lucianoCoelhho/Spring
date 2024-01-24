package com.tabelaCarro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tabelaCarro.api.models.Cliente;

public interface Repositorio extends JpaRepository<Cliente, Long>{

}
