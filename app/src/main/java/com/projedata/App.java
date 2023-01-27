package com.projedata;

import java.util.List;
import java.util.Scanner;

import com.projedata.models.Funcionario;
import com.projedata.repositories.FuncionarioRepository;

/**
 * Main class
 *
 */
public class App {
  public static void main(String[] args) {
    Empresa.criaEmpresa();
    List<Funcionario> funcionarios = Empresa.getFuncionarios();
    FuncionarioRepository repository = new FuncionarioRepository();
    for (Funcionario funcionario : funcionarios) {
      repository.setFuncionario(funcionario);
    }

    Scanner scanner = new Scanner(System.in);
    int input = gerenciaInputNumérico(scanner);
    while (input != 0) {
      if (input < 0 || input > 9) {
        System.out.println("Digite uma opção válida");
        input = gerenciaInputNumérico(scanner);
      }
      gerenciaRelatorio(scanner, input, repository);
      input = gerenciaInputNumérico(scanner);
    }
    System.out.println("Obrigado, tenha uma boa semana!");
    scanner.close();

  }

  private static int gerenciaInputNumérico(Scanner scanner) {
    try {
      System.out.println("Escolha um opção abaixo:");
      System.out.println("Digite 0 para finalizar");
      System.out.println("Digite 1 para listar quadro de funcionários");
      System.out.println("Digite 2 para excluir alguém do quadro de funcionários");
      System.out.println("Digite 3 para dar um aumento de 10% no salário");
      System.out.println("Digite 4 para listar usuários por uma função específica");
      System.out.println("Digite 5 para listar usuários nascidos no mês 10 e mês 12");
      System.out.println("Digite 6 para listar funcionário mais antigo");
      System.out.println("Digite 7 para listar quadro de funcionários alfabeticamente");
      System.out.println("Digite 8 para listar total da folha salarial");
      System.out.println("Digite 9 para listar quantos salários mínimos cada funcionário recebe");
      return Integer.parseInt(scanner.next());
    } catch (NumberFormatException excep) {
      System.out.println("Digite uma opção válida");
      return gerenciaInputNumérico(scanner);
    }
  }

  private static void gerenciaRelatorio(
      Scanner scanner,
      int option,
      FuncionarioRepository repository) {
    switch (option) {
      case 1:
        repository.imprimeFuncionarios();
        break;
      case 2:
        System.out.println("Digite o nome do funcionário a ser removido");
        String nome = scanner.next();
        repository.removeFuncionario(nome);
        break;
      case 3:
        repository.aumentaSalario();
        break;
      case 4:
        System.out.println("Digite a função a ser agrupada");
        String funcao = scanner.next();
        repository.agrupaFuncionarioPorFuncao(funcao);
        break;
      case 5:
        repository.agrupaFuncionarioPorMesNascimento();
        break;
      case 6:
        repository.imprimeFuncionarioMaisAntigo();
        break;
      case 7:
        repository.imprimeFuncionariosAlfabeticamente();
        break;
      case 8:
        repository.imprimeFolhaSalarial();
        break;
      case 9:
        repository.imprimeTotalSalariosMinimosPorPessoa();
        break;
      default:
        break;
    }
  }
}
