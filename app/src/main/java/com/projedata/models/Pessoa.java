package com.projedata.models;

import java.time.LocalDate;

public class Pessoa {
  private String nome;
  private LocalDate nascimento;

  public Pessoa(String nome, String nascimento) {
    this.nome = nome;
    this.nascimento = LocalDate.parse(nascimento);
  }

  public String getNome() {
    return this.nome;
  }

  public LocalDate getNascimento() {
    return this.nascimento;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setNascimento(LocalDate nascimento) {
    this.nascimento = nascimento;
  }
}
