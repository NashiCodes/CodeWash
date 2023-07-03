package CodeWash.model;

public class Horario {
    private Dias dia;
    private String hora;

    public Horario(Dias dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public Dias getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public void setDia(Dias dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
