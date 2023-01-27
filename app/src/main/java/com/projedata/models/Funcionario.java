package com.projedata.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.projedata.repositories.FormaterRepository;

public class Funcionario extends Pessoa {
  private BigDecimal salario;
  private String funcao;

  public Funcionario(String nome, String nascimento, String salario, String funcao) {
    super(nome, nascimento);
    this.salario = new BigDecimal(salario).setScale(2, RoundingMode.HALF_EVEN);
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return this.salario;
  }

  public String getFuncao() {
    return this.funcao;
  }

  public void setSalaraio(String salario) {
    this.salario = new BigDecimal(salario).setScale(2, RoundingMode.HALF_EVEN);
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  @Override
  public String toString() {
    return "Nome: " + this.getNome() + "\nFunção: " + this.getFuncao() + "\nNascimento: "
        + FormaterRepository.formataData(this.getNascimento())
        + "\nSalário: R$ " + FormaterRepository.formataSalario(this.getSalario().doubleValue());
  }
}
