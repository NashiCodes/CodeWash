// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package trabalhooop.model;

import trabalhooop.exception.HorarioException;

import java.util.*;

public class Place {
    private String name;
    private final String email;
    private final HashMap<String, Double> produtos;
    private final Agenda agenda;
    private final List<Dias.Dia> diasAbertos;
    private int abertura;
    private int fechamento;
    private int intervalo;

    public Place(String name, String email) {
        this.name = name;
        this.email = email;
        this.produtos = new HashMap<>();
        this.agenda = new Agenda();
        this.diasAbertos = new ArrayList<>();
    }

    public boolean setFuncionamento(int abertura, int fechamento, int intervalo) throws HorarioException {
        if (abertura < fechamento && abertura >= 0 && fechamento <= 24 && intervalo >= 0 && intervalo <= 24) {
            this.abertura = abertura;
            this.fechamento = fechamento;
            this.intervalo = intervalo;
            return true;
        } else {
            throw new HorarioException("Horário inválido.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Double> getProdutos() {
        return produtos;
    }

    public void addProduto(String nome, double preco) {
        this.produtos.put(nome, preco);
    }

    public void removerProduto(String nome) {
        this.produtos.remove(nome);
    }

    public void editarPrecoProduto(String nome, double novoPreco) {
        if (this.produtos.containsKey(nome)) {
            this.produtos.put(nome, novoPreco);
        } else {
            System.out.println("O produto " + nome + " não está cadastrado.");
        }
    }

    public void marcarHorario(String email, Dias.Dia dia, String hora) throws HorarioException {
        this.agenda.setHorario(email, dia, hora);
    }

    public String getEmail() {
        return email;
    }

    public boolean verifica(Dias.Dia dia, int hora){
        if (hora <this.abertura && hora >= this.fechamento && hora == this.intervalo) {
            return false;
        }
        return this.agenda.verifica(dia, String.valueOf(hora));
    }

    public void setDiasAbertos(List<Dias.Dia> diasAbertos) {
        this.diasAbertos.addAll(diasAbertos);
    }

    public List<Dias.Dia> getDiasAbertos() {
        return this.diasAbertos;
    }

    public int getAbertura() {
        return this.abertura;
    }

    public int getFechamento() {
        return this.fechamento;
    }

    public int getIntervalo() {
        return this.intervalo;
    }
}
