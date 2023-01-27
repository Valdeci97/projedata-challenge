package com.projedata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.projedata.models.Funcionario;
import com.projedata.repositories.FuncionarioRepository;

/**
 * Unit test for simple App.
 */
public class AppTest {

  @BeforeAll
  public static void initCompany() {
    Empresa.criaEmpresa();
  }

  @Test
  @DisplayName("1 - Should have all employees")
  public void generateEmployees() {
    List<Funcionario> funcionarios = Empresa.getFuncionarios();

    int expected = 10;

    assertEquals(expected, funcionarios.size());
  }

  @Test
  @DisplayName("2 - Should return 2 employees")
  public void readEmployeByBirthDay() {
    String input = String.format("5", System.lineSeparator());
    ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
    System.setIn(bais);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    List<Funcionario> funcionarios = Empresa.getFuncionarios();
    FuncionarioRepository repository = new FuncionarioRepository();

    for (Funcionario funcionario : funcionarios) {
      repository.setFuncionario(funcionario);
    }

    repository.agrupaFuncionarioPorMesNascimento();

    String[] lines = baos.toString().split(System.lineSeparator());
    String out = lines[1];

    String expected = "Nome: Maria";

    assertEquals(expected, out);
  }

  @Test
  @DisplayName("3 - Should have salario and nascimento fields formated")
  public void readEmployeeSalary() {
    String input = String.format("5", System.lineSeparator());
    ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
    System.setIn(bais);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    List<Funcionario> funcionarios = Empresa.getFuncionarios();
    FuncionarioRepository repository = new FuncionarioRepository();

    for (Funcionario funcionario : funcionarios) {
      repository.setFuncionario(funcionario);
    }

    repository.imprimeFuncionarios();

    String[] lines = baos.toString().split(System.lineSeparator());
    String birthOut = lines[3];
    String salaryOut = lines[4];

    String expectedBirthDate = "Nascimento: 18/10/2000";
    String expectedSalary = "Salário: R$ 2.009,44";

    assertEquals(expectedBirthDate, birthOut);
    assertEquals(expectedSalary, salaryOut);
  }

  @Test
  @DisplayName("4 - Should remove employee")
  public void removeEmployee() {
    List<Funcionario> funcionarios = Empresa.getFuncionarios();
    FuncionarioRepository repository = new FuncionarioRepository();

    for (Funcionario funcionario : funcionarios) {
      repository.setFuncionario(funcionario);
    }

    repository.removeFuncionario("João");

    int expected = 9;

    List<Funcionario> funcionariosAposRemocao = repository.getFuncionarios();

    assertEquals(expected, funcionariosAposRemocao.size());
  }

  @Test
  @DisplayName("5 - Should show the most experient employee")
  public void showExprientEmployee() {
    String input = String.format("5", System.lineSeparator());
    ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
    System.setIn(bais);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    List<Funcionario> funcionarios = Empresa.getFuncionarios();
    FuncionarioRepository repository = new FuncionarioRepository();

    for (Funcionario funcionario : funcionarios) {
      repository.setFuncionario(funcionario);
    }

    repository.imprimeFuncionarioMaisAntigo();

    String[] lines = baos.toString().split(System.lineSeparator());
    String nameOut = lines[1];
    String ageOut = lines[2];

    String expectedName = "Nome: Caio";
    String expectedAge = "Idade: 61";

    assertEquals(expectedName, nameOut);
    assertEquals(expectedAge, ageOut);
  }

  @Test
  @DisplayName("6 -  Should return all employees sorted by alphabetical order")
  public void alphabeticalOrderSortEmployees() {
    String input = String.format("5", System.lineSeparator());
    ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
    System.setIn(bais);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    List<Funcionario> funcionarios = Empresa.getFuncionarios();
    FuncionarioRepository repository = new FuncionarioRepository();

    for (Funcionario funcionario : funcionarios) {
      repository.setFuncionario(funcionario);
    }

    repository.imprimeFuncionariosAlfabeticamente();

    String[] lines = baos.toString().split(System.lineSeparator());
    String out = lines[1];

    String expected = "Nome: Alice";

    assertEquals(expected, out);
  }

  @Test
  @DisplayName("7 - Should have the right salary amount")
  public void companySalaryAmount() {
    String input = String.format("5", System.lineSeparator());
    ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
    System.setIn(bais);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    List<Funcionario> funcionarios = Empresa.getFuncionarios();
    FuncionarioRepository repository = new FuncionarioRepository();

    for (Funcionario funcionario : funcionarios) {
      repository.setFuncionario(funcionario);
    }

    repository.imprimeFolhaSalarial();

    String[] lines = baos.toString().split(System.lineSeparator());
    String out = lines[1];

    String expected = "Total: R$ 48.563,31";

    assertEquals(expected, out);
  }

  @Test
  @DisplayName("8 - Should show how many basic salaries an employee receive")
  public void howManyBasicSalary() {
    String input = String.format("5", System.lineSeparator());
    ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
    System.setIn(bais);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    List<Funcionario> funcionarios = Empresa.getFuncionarios();
    FuncionarioRepository repository = new FuncionarioRepository();

    for (Funcionario funcionario : funcionarios) {
      repository.setFuncionario(funcionario);
    }

    repository.imprimeTotalSalariosMinimosPorPessoa();

    String[] lines = baos.toString().split(System.lineSeparator());
    String out = lines[1];

    String expected = "João recebe 1,88 salários mínimos";

    assertEquals(expected, out);
  }
}
