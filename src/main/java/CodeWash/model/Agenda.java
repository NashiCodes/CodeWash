// NOME: Gabriel de Oliveira Vieira                         MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                           MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                      MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                  MATRÍCULA: 202165193AC

package CodeWash.model;

import CodeWash.exception.HorarioException;

import java.util.*;

public class Agenda {
    private final HashMap<String, Horario> horarios;

    public Agenda() {
        this.horarios = new HashMap<>();
    }

    public void setHorario(String email, Dias dia, String hora) throws HorarioException {
        if (this.verifica(dia, hora)) {
            this.horarios.put(email, new Horario(dia, hora));
        } else {
            throw new HorarioException("Horário indisponível.");
        }
    }

    public boolean verifica(Dias dia, String hora) {
        int cont = 0;
        for (Horario horario : this.horarios.values()) {
            if (horario.dia().equals(dia) && horario.hora().equals(hora)) {
                cont++;
            }
        }
        return cont < 2;
    }

    public int getCont(Dias dia, int hora){
        int cont = 0;
        String horaString = hora > 9 ? hora + ":00" : "0" + hora + ":00";
        for (Horario horario : this.horarios.values()) {
            if (horario.dia().equals(dia) && horario.hora().equals(horaString)) {
                cont++;
            }
        }
        return cont;
    }


    public List<String> getClientes(Dias dia, int hora) {
        final List<String> clientes = new ArrayList<>();
        String horaString = hora > 9 ? hora + ":00" : "0" + hora + ":00";
        for (Map.Entry<String, Horario> entry : this.horarios.entrySet()) {
            if (entry.getValue().dia().equals(dia) && entry.getValue().hora().equals(horaString)) {
                clientes.add(entry.getKey());
            }
        }
        return clientes;
    }

    public void removeCliente(List<String> clientes) {
        for (String cliente : clientes) {
            this.horarios.remove(cliente);
        }
    }
}
