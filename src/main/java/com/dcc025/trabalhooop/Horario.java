package com.dcc025.trabalhooop;

import java.util.*;

public class Horario {

   private List<HashMap<String, Integer>> horarios;// Array de hashMap para armazenar
                                                   // os horarios referentes de cada dia da semana
   private final int Dias_de_Funcionamento; // varivel para armazenar os dias da semana
                                            // que o lava jato funciona

   private final List<Integer> horario_de_Funcionamento; // Vetor que armazena os Horarios de Funcionamento

   public Horario(int dias) {
      this.Dias_de_Funcionamento = dias;
      this.horario_de_Funcionamento = new ArrayList<Integer>(2);
      initHF();
      horarios = new ArrayList<HashMap<String, Integer>>(this.Dias_de_Funcionamento);
      for (int i = 0; i < this.Dias_de_Funcionamento; i++) {
         horarios.add(new HashMap<String, Integer>()); // inicializa todos os horários
                                                       // com um HashMap vazio
      }

   }

   private void initHF() {
      for (int i = 8; this.horario_de_Funcionamento.size() < 2; i += 10)
         setHF(i);
   }

   public void setHorario(int diaSemana, String horario) throws HorarioJaOcupadoException {
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
      if (diaSemana >= 0 && diaSemana < this.Dias_de_Funcionamento) {// Se o dia selecionado for valido
         HashMap<String, Integer> horariosDia = horarios.get(diaSemana);// pega todos os horarios desse dia
         if (horariosDia.containsKey(horario)) {// verifica se nesse dia pelo menos alguem ja seleciou tal horario
            return horariosDia.get(horario) + " pessoas marcadas para este horário.";// retora o numeror de pessoas que
                                                                                     // selecionaram
         } else {
            return "Nenhuma pessoa marcada para este horário.";// caso contrario retorna mensagem de erro
         }
      } else {
         return "Dia selecionado invalido!!";
      }
   }

   public ArrayList<String> getHhrsIndisponiveis(int diaSemana) {
      ArrayList<String> horariosIndisponiveis = new ArrayList<String>();
      if (diaSemana >= 0 && diaSemana < this.Dias_de_Funcionamento) { // se for um dia valido
         HashMap<String, Integer> horariosDia = horarios.get(diaSemana);// pega todos os horarios desse dia
         for (String horario : horariosDia.keySet()) {// percorre todos os horariosdesse dia
            if (horariosDia.get(horario) == 2) {// verifica se esse horario ainda tem 2 pessoas marcadas
               horariosIndisponiveis.add(horario);// adiciona esse horario na lista de horarios indisponiveis
            }
         }
      }
      return horariosIndisponiveis;
   }

   public void setHF(int hr) {
      this.horario_de_Funcionamento.add(hr);
   }

   public static class HorarioJaOcupadoException extends Exception { // classe estatica que retorna a mensagem de erro
      public HorarioJaOcupadoException(String mensagem) {
         super(mensagem);
      }
   }

}
