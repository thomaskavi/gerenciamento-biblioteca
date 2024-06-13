package com.thomas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String autor;
  private String editora;
  private String genero;
  private String status;

  public Livro() {
  }

  public Livro(Long id, String titulo, String autor, String editora, String genero, String status) {
    this.id = id;
    this.titulo = titulo;
    this.autor = autor;
    this.editora = editora;
    this.genero = genero;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getEditora() {
    return editora;
  }

  public void setEditora(String editora) {
    this.editora = editora;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + ", genero=" + genero
        + ", status=" + status + "]";
  }

}
