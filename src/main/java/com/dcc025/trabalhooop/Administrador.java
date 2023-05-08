package com.dcc025.trabalhooop;

import java.util.*;

public class Administrador extends Usuario{
    private HashMap<String, Double> produtos;

    public Administrador(String nome, String telefone, String email) {
        super(nome, telefone, email);
        this.produtos = new HashMap<String, Double>();
    }

    public void adicionarProduto(String nome, double preco) {
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
}