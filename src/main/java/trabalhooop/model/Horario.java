package trabalhooop.model;

public class Horario {
    private Dias.Dia dia;
    private String hora;

    public Horario(Dias.Dia dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public Dias.Dia getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public void setDia(Dias.Dia dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
