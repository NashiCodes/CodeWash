// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package trabalhooop.model;

import java.util.*;

public class Place {
    private String name;
    private final String email;
    private final HashMap<String, Double> produtos;
    private final List<Usuario> clientes;
    private final Horario horarios;

    public Place(String name, String email) {
        this.name = name;
        this.email = email;
        this.produtos = new HashMap<>();
        this.clientes = new ArrayList<>();
        this.horarios = new Horario(0);
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

    public void adicionarCliente(Usuario cliente) {
        this.clientes.add(cliente);
    }

    public void removerCliente(Usuario cliente) {
        this.clientes.remove(cliente);
    }

    public void printProdutos() {
        for (String produto : produtos.keySet()) {
            System.out.println(produto + ": $" + produtos.get(produto));
        }
    }

    public String getEmail() {
        return email;
    }

}
