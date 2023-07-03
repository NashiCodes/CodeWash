package trabalhooop.model;

import trabalhooop.exception.HorarioException;

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
            if (horario.getDia().equals(dia) && horario.getHora().equals(hora)) {
                cont++;
            }
        }
        return cont < 2;
    }
}
