package com.projedata;

import java.util.ArrayList;
import java.util.List;

import com.projedata.models.Funcionario;

public class Empresa {
  private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();

  public static void criaEmpresa() {
    Funcionario maria = new Funcionario("Maria", "2000-10-18", "2009.44", "Operador");
    Funcionario joao = new Funcionario("João", "1990-05-12", "2284.38", "Operador");
    Funcionario caio = new Funcionario("Caio", "1961-05-02", "9836.14", "Coordenador");
    Funcionario miguel = new Funcionario("Miguel", "1988-10-14", "19119.88", "Diretor");
    Funcionario alice = new Funcionario("Alice", "1995-01-05", "2234.68", "Recepcionista");
    Funcionario heitor = new Funcionario("Heitor", "1999-11-19", "1582.72", "Operador");
    Funcionario arthur = new Funcionario("Arthur", "1993-03-31", "4071.84", "Contador");
    Funcionario laura = new Funcionario("Laura", "1994-07-08", "3017.45", "Gerente");
    Funcionario heloisa = new Funcionario("Heloísa", "2003-05-24", "1606.85", "Eletricista");
    Funcionario helena = new Funcionario("Helena", "1996-09-02", "2799.93", "Gerente");
    funcionarios.add(maria);
    funcionarios.add(joao);
    funcionarios.add(caio);
    funcionarios.add(miguel);
    funcionarios.add(alice);
    funcionarios.add(heitor);
    funcionarios.add(arthur);
    funcionarios.add(laura);
    funcionarios.add(heloisa);
    funcionarios.add(helena);
  }

  public static List<Funcionario> getFuncionarios() {
    return funcionarios;
  }
}
