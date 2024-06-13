package com.thomas.service;

import com.thomas.entity.Livro;
import com.thomas.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

  @Autowired
  private LivroRepository livroRepository;

  public List<Livro> findAll() {
    return livroRepository.findAll();
  }

  public Optional<Livro> findById(Long id) {
    return livroRepository.findById(id);
  }

  public Livro save(Livro livro) {
    return livroRepository.save(livro);
  }

  public Livro update(Long id, Livro livroDetails) {
    Optional<Livro> optionalLivro = livroRepository.findById(id);

    if (optionalLivro.isPresent()) {
      Livro livro = optionalLivro.get();
      livro.setTitulo(livroDetails.getTitulo());
      livro.setAutor(livroDetails.getAutor());
      livro.setEditora(livroDetails.getEditora());
      livro.setGenero(livroDetails.getGenero());
      livro.setStatus(livroDetails.getStatus());
      return livroRepository.save(livro);
    }

    return null;
  }

  public boolean delete(Long id) {
    Optional<Livro> optionalLivro = livroRepository.findById(id);

    if (optionalLivro.isPresent()) {
      livroRepository.delete(optionalLivro.get());
      return true;
    }

    return false;
  }
}
