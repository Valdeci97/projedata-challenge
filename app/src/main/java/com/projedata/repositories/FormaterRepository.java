package com.projedata.repositories;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormaterRepository {
  public static String formataSalario(double salario) {
    DecimalFormat formatador = new DecimalFormat("###,###,###.00");
    String salarioFormatado = formatador.format(salario);
    return salarioFormatado;
  }

  public static String formataData(LocalDate data) {
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String novaData = data.format(formatador);
    return novaData;
  }
}
