package com.thomas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thomas.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
