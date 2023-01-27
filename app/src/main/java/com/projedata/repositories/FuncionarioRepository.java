package com.projedata.repositories;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projedata.models.Funcionario;

public class FuncionarioRepository {
  private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

  public FuncionarioRepository() {
  }

  public void setFuncionario(Funcionario funcionario) {
    funcionarios.add(funcionario);
  }

  public List<Funcionario> getFuncionarios() {
    return this.funcionarios;
  }

  public void removeFuncionario(String nome) {
    Funcionario funcionarioParaRemover = this.funcionarios
        .stream()
        .filter((funcionario) -> nome.equals(funcionario.getNome()))
        .findAny()
        .orElse(null);
    if (funcionarioParaRemover != null) {
      funcionarios.remove(funcionarioParaRemover);
      return;
    }
    System.out.printf("Funcionário não %s existe", nome);
    this.imprimeLinhaSeparadora();
  }

  public void imprimeFuncionarios() {
    System.out.println("Funcionários");
    funcionarios.forEach(System.out::println);
    this.imprimeLinhaSeparadora();
  }

  public void aumentaSalario() {
    funcionarios.forEach((funcionario) -> {
      double salarioAtual = funcionario.getSalario().doubleValue();
      Double novoSalario = salarioAtual + 0.1 * salarioAtual;
      funcionario.setSalaraio(novoSalario.toString());
    });
  }

  public void agrupaFuncionarioPorFuncao(String funcao) {
    Map<Integer, Funcionario> agrupador = new HashMap<Integer, Funcionario>();
    List<Funcionario> funcionariosPorFuncao = this.funcionarios
        .stream()
        .filter((funcionario) -> funcionario.getFuncao() == funcao)
        .toList();
    funcionariosPorFuncao.forEach((funcionario) -> agrupador.put(this.funcionarios.indexOf(funcionario), funcionario));
    if (funcionariosPorFuncao.size() > 0) {
      System.out.printf("Funcionários por função %s\n", funcao);
      agrupador.entrySet().forEach((agrupado) -> System.out.println(agrupado.getValue()));
      this.imprimeLinhaSeparadora();
      return;
    }
    System.out.printf("Não existem funcionários para a função %s\n", funcao);
    this.imprimeLinhaSeparadora();
  }

  public void agrupaFuncionarioPorMesNascimento() {
    Map<Integer, Funcionario> agrupador = new HashMap<Integer, Funcionario>();
    List<Funcionario> funcionariosPorMes = this.funcionarios
        .stream()
        .filter((funcionario) -> funcionario.getNascimento().toString().split("-")[1].contains("10")
            || funcionario.getNascimento().toString().split("-")[1].contains("12"))
        .toList();
    funcionariosPorMes.forEach((funcionario) -> agrupador.put(this.funcionarios.indexOf(funcionario), funcionario));
    System.out.println("Funcionários por meses 10 e 12");
    agrupador.entrySet().forEach((agrupado) -> System.out.println(agrupado.getValue()));
    this.imprimeLinhaSeparadora();
  }

  public void imprimeFuncionarioMaisAntigo() {
    LocalDate agora = LocalDate.now();
    int anoMaisAntigo = agora.getYear();
    Funcionario funcionarioMaisAntigo = null;
    for (Funcionario funcionario : this.funcionarios) {
      int anoNascimento = funcionario.getNascimento().getYear();
      if (anoNascimento < anoMaisAntigo) {
        anoMaisAntigo = anoNascimento;
        funcionarioMaisAntigo = funcionario;
      }
    }
    int idade = Period.between(funcionarioMaisAntigo.getNascimento(), agora).getYears();
    System.out.printf("Funcionário mais antigo\nNome: %s\nIdade: %d\n", funcionarioMaisAntigo.getNome(), idade);
    this.imprimeLinhaSeparadora();
  }

  public void imprimeFuncionariosAlfabeticamente() {
    List<Funcionario> funcionariosOrganizadosPorNome = this.funcionarios.stream()
        .sorted((func1, func2) -> func1.getNome().compareTo(func2.getNome())).toList();
    System.out.println("Funcionários em ordem alfabética");
    funcionariosOrganizadosPorNome.forEach(System.out::println);
    this.imprimeLinhaSeparadora();
  }

  public void imprimeFolhaSalarial() {
    double total = this.funcionarios
        .stream()
        .mapToDouble((funcionario) -> funcionario.getSalario().doubleValue())
        .reduce(0, (acc, curr) -> acc + curr);
    System.out.printf("Folha salarial atual\nTotal: R$ %s\n", FormaterRepository.formataSalario(total));
    this.imprimeLinhaSeparadora();
  }

  public void imprimeTotalSalariosMinimosPorPessoa() {
    double salarioMinimo = 1212.00;
    Map<String, Double> agrupador = new HashMap<String, Double>();
    this.funcionarios
        .forEach(
            (funcionario) -> agrupador
                .put(funcionario.getNome(), funcionario.getSalario().doubleValue() / salarioMinimo));
    System.out.println("Total de salários mínimos ganhos por funcionário");
    agrupador.entrySet().forEach(
        (agrupado) -> System.out.printf("%s recebe %s salários mínimos\n", agrupado.getKey(),
            FormaterRepository.formataSalario(agrupado.getValue())));
    this.imprimeLinhaSeparadora();
  }

  private void imprimeLinhaSeparadora() {
    System.out.println("\n-----------*****-----------\n");
  }
}
