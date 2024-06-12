package com.thomas.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprestimo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "livro_id")
  private Livro livro;

  @ManyToOne
  @JoinColumn(name = "usuario_id")

  private Usuario usuario;
  private Date dataEmprestimo;
  private Date dataDevolucaoPrevista;
  private Date dataDevolucaoRealizada;

  public Emprestimo() {
  }

  public Emprestimo(Long id, Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucaoPrevista,
      Date dataDevolucaoRealizada) {
    this.id = id;
    this.livro = livro;
    this.usuario = usuario;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    this.dataDevolucaoRealizada = dataDevolucaoRealizada;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Livro getLivro() {
    return livro;
  }

  public void setLivro(Livro livro) {
    this.livro = livro;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }

  public void setDataEmprestimo(Date dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }

  public Date getDataDevolucaoPrevista() {
    return dataDevolucaoPrevista;
  }

  public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
    this.dataDevolucaoPrevista = dataDevolucaoPrevista;
  }

  public Date getDataDevolucaoRealizada() {
    return dataDevolucaoRealizada;
  }

  public void setDataDevolucaoRealizada(Date dataDevolucaoRealizada) {
    this.dataDevolucaoRealizada = dataDevolucaoRealizada;
  }

  @Override
  public String toString() {
    return "Emprestimo [id=" + id + ", livro=" + livro + ", usuario=" + usuario + ", dataEmprestimo=" + dataEmprestimo
        + ", dataDevolucaoPrevista=" + dataDevolucaoPrevista + ", dataDevolucaoRealizada=" + dataDevolucaoRealizada
        + "]";
  }

}
