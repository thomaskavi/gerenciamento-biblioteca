package com.thomas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thomas.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
