// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package com.dcc025.trabalhooop.Local;

import java.util.*;

public class Horario {

    private final List<HashMap<String, Integer>> horarios;// Array de hashMap para armazenar
    // os horarios referentes de cada dia da semana
    private int diasUteis; // varivel para armazenar os dias da semana
    // que o lava jato funciona

    private final List<Integer> horario_de_Funcionamento; // Vetor que armazena os Horarios de Funcionamento

    public Horario(int dias) {
        this.diasUteis = dias;
        this.horario_de_Funcionamento = new ArrayList<>(2);
        initHF();
        horarios = new ArrayList<>(this.diasUteis);
        for (int i = 0; i < 7; i++) {
            horarios.add(new HashMap<>()); // inicializa todos os horários
            // com um HashMap vazio
        }

    }

    private void initHF() {
        for (int i = 8; this.horario_de_Funcionamento.size() < 2; i += 10)
            setHF(i);
    }

    public void setHorario(int diaSemana, String horario) throws HorarioJaOcupadoException {
        if (diaSemana >= 0 && diaSemana < this.diasUteis) { // se o dia selecionado pelo usuario for valido
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
        if (diaSemana >= 0 && diaSemana < this.diasUteis) {// Se o dia selecionado for valido
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
        ArrayList<String> horariosIndisponiveis = new ArrayList<>();
        if (diaSemana >= 0 && diaSemana < this.diasUteis) { // se for um dia valido
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

    public void setDiasUteis(int D) {
        this.diasUteis = D;
    }

    public int getDiasUteis() {
        return this.diasUteis;
    }

    public String nomeDia(int dia) {
        return switch (dia) {
            case 0 -> "Segunda-Feira";
            case 1 -> "Terça-Feira";
            case 2 -> "Quarta-Feira";
            case 3 -> "Quinta-Feira";
            case 4 -> "Sexta-Feira";
            case 5 -> "Sabado";
            case 6 -> "Domingo";
            default -> "Dia invalido!!";
        };
    }

    public void printDia(int i) {
        ArrayList<String> hrs = this.getHhrsIndisponiveis(i);
        for (String hr : hrs) {
            System.out.println(hr + " Ocupado");
        }
    }

    public static class HorarioJaOcupadoException extends Exception { // classe estatica que retorna a mensagem de erro
        public HorarioJaOcupadoException(String mensagem) {
            super(mensagem);
        }
    }

}
