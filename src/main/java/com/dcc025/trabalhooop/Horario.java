package com.dcc025.trabalhooop;

import java.util.*;

public class Horario {

   private ArrayList<HashMap<String, Integer>> horarios;
   private final int Dias_de_Funcionamento;

   public Horario(int dias) {
      this.Dias_de_Funcionamento = dias;
      horarios = new ArrayList<HashMap<String, Integer>>(this.Dias_de_Funcionamento); // 7 dias na semana
      for (int i = 0; i < this.Dias_de_Funcionamento; i++) {
         horarios.add(new HashMap<String, Integer>()); // inicializa todos os horários
         // com um HashMap vazio
      }
   }

   public void setHorario(int diaSemana, String horario, String nome) throws HorarioJaOcupadoException {
      if (diaSemana >= 0 && diaSemana < this.Dias_de_Funcionamento) {
         HashMap<String, Integer> horariosDia = horarios.get(diaSemana);
         if (horariosDia.containsKey(horario)) {
            int numPessoas = horariosDia.get(horario);
            if (numPessoas >= 2) {
               throw new HorarioJaOcupadoException("Horário já ocupado por duas pessoas.");
            } else {
               horariosDia.put(horario, numPessoas + 1);
            }
         } else {
            horariosDia.put(horario, 1);
         }
      }
   }

   public String getHorario(int diaSemana, String horario) {
      if (diaSemana >= 0 && diaSemana < this.Dias_de_Funcionamento) {
         HashMap<String, Integer> horariosDia = horarios.get(diaSemana);
         if (horariosDia.containsKey(horario)) {
            return horariosDia.get(horario) + " pessoas marcadas para este horário.";
         } else {
            return "Nenhuma pessoa marcada para este horário.";
         }
      } else {
         return "";
      }
   }

   public static class HorarioJaOcupadoException extends Exception {
      public HorarioJaOcupadoException(String mensagem) {
         super(mensagem);
      }
   }

}
