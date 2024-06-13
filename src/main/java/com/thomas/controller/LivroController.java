package com.thomas.controller;

import com.thomas.entity.Livro;
import com.thomas.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

  @Autowired
  private LivroService livroService;

  @GetMapping
  public List<Livro> getAllLivros() {
    return livroService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
    Optional<Livro> optionalLivro = livroService.findById(id);

    if (optionalLivro.isPresent()) {
      return ResponseEntity.ok(optionalLivro.get());
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public Livro createLivro(@RequestBody Livro livro) {
    return livroService.save(livro);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody Livro livroDetails) {
    Livro updatedLivro = livroService.update(id, livroDetails);

    if (updatedLivro != null) {
      return ResponseEntity.ok(updatedLivro);
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
    boolean deleted = livroService.delete(id);

    if (deleted) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.notFound().build();
  }
}
