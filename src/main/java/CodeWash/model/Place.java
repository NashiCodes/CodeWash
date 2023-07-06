// NOME: Gabriel de Oliveira Vieira                         MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                           MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                      MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                  MATRÍCULA: 202165193AC

package CodeWash.model;

import CodeWash.exception.HorarioException;

import java.util.*;

public class Place {
    private final String name;
    private final String email;
    private final List<Produto> produtos;
    private final Agenda agenda;
    private final List<Dias> diasAbertos;
    private int abertura;
    private int fechamento;
    private int intervalo;

    public Place(String name, String email) {
        this.name = name;
        this.email = email;
        this.produtos = new ArrayList<>();
        this.agenda = new Agenda();
        this.diasAbertos = new ArrayList<>();
    }

    public void setFuncionamento(int abertura, int intervalo, int fechamento) throws HorarioException {
        if (abertura >= 0 && fechamento <= 24 && intervalo > abertura && intervalo < fechamento) {
            this.abertura = abertura;
            this.fechamento = fechamento;
            this.intervalo = intervalo;
        } else {
            throw new HorarioException("Horário inválido.");
        }
    }

    public String getName() {
        return name;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(String nome, double preco, int quantidade) {
        this.produtos.add(new Produto(nome, preco, quantidade));
    }

    public void removerProduto(int index) {
        this.produtos.remove(index);
    }

    public void editarProduto(int idx, String nome, double novoPreco) {
        this.produtos.get(idx).setNome(nome);
        this.produtos.get(idx).setPreco(novoPreco);
    }

    public void marcarHorario(String email, Dias dia, String hora) throws HorarioException {
        this.agenda.setHorario(email, dia, hora);
    }

    public String getEmail() {
        return email;
    }

    public boolean verifica(Dias dia, int hora) {
        if (hora >= this.abertura && hora < this.fechamento && hora != this.intervalo) {
            return this.agenda.verifica(dia, Integer.toString(hora));
        }
        return false;
    }

    public void setDiasAbertos(List<Dias> diasAbertos) {
        this.diasAbertos.addAll(diasAbertos);
    }

    public List<Dias> getDiasAbertos() {
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

    public int getCont(Dias dia, int hora) {
        return this.agenda.getCont(dia, hora);
    }

    public List<String> getClientes(Dias dia, int hora) {
        return this.agenda.getClientes(dia, hora);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void efetuarCompra(Produto produto, int quantidade) {
        produtos.get(produtos.indexOf(produto)).setQuantidade(produtos.get(produtos.indexOf(produto)).getQuantidade() - quantidade);
    }

    public void removeCliente(List<String> clientes) {
        this.agenda.removeCliente(clientes);
    }
}
