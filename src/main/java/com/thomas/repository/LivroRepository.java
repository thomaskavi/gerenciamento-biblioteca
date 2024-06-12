package com.thomas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thomas.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
