package com.dcc025.trabalhooop;

import java.util.*;

public class Horario {

   private ArrayList<HashMap<String, Integer>> horarios;// Array de hashMap para armazenar
                                                        // os horarios referentes de cada dia da semana
   private final int Dias_de_Funcionamento; // varivel para armazenar os dias da semana
                                            // que o lava jato funciona

   public Horario(int dias) {
      this.Dias_de_Funcionamento = dias;
      horarios = new ArrayList<HashMap<String, Integer>>(this.Dias_de_Funcionamento);
      for (int i = 0; i < this.Dias_de_Funcionamento; i++) {
         horarios.add(new HashMap<String, Integer>()); // inicializa todos os horários
                                                       // com um HashMap vazio
      }
   }

   public void setHorario(int diaSemana, String horario, String nome) throws HorarioJaOcupadoException {
      if (diaSemana >= 0 && diaSemana < this.Dias_de_Funcionamento) { // se o dia selecionado pelo usuario for valido
         HashMap<String, Integer> horariosDia = horarios.get(diaSemana);// pega todos os horarios desse dia
         if (horariosDia.containsKey(horario)) {// verifica se nesse dia outra pessoa ja seleciou tal horario
            int numPessoas = horariosDia.get(horario);// pega o numero de pessas desse horario
            if (numPessoas >= 2) {// verifica se 2 ou mais pessoas ja marcaram esse horario
               // se for verdade o programa cai num caso de exeção e sai da função com uma
               // mensagem de error
               throw new HorarioJaOcupadoException("Horário já ocupado por duas pessoas");
            } else {
               horariosDia.put(horario, numPessoas + 1);// caso contrario (1 pessoa só q marcou) o programa aceita e
                                                        // marca o horario
            }
         } else {
            horariosDia.put(horario, 1);// Caso contrario (nenhuma pessoa marcou) o programa aceita e
                                        // marca o horario
         }
      }
   }

   public String getHorario(int diaSemana, String horario) {
      if (diaSemana >= 0 && diaSemana < this.Dias_de_Funcionamento) {//Se o dia selecionado for valido
         HashMap<String, Integer> horariosDia = horarios.get(diaSemana);// pega todos os horarios desse dia
         if (horariosDia.containsKey(horario)) {// verifica se nesse dia pelo menos alguem ja seleciou tal horario
            return horariosDia.get(horario) + " pessoas marcadas para este horário.";// retora o numeror de pessoas que selecionaram
         } else {
            return "Nenhuma pessoa marcada para este horário.";//caso contrario retorna mensagem de erro
         }
      } else {
         return "Dia selecionado invalido!!";
      }
   }

   public static class HorarioJaOcupadoException extends Exception { //classe estatica que retorna a mensagem de erro
      public HorarioJaOcupadoException(String mensagem) {
         super(mensagem);
      }
   }

}
