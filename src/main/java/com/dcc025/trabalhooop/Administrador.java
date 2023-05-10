package com.dcc025.trabalhooop;

import java.util.*;

public class Administrador extends Usuario {
    private HashMap<String, Double> produtos;
    private ArrayList<Client> clientes;

    public Administrador(String nome, String telefone, String email, String senha) {
        super(nome, telefone, email, senha);
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

    public void adicionarCliente(Client cliente) {
        this.clientes.add(cliente);
    }

    public void removerCliente(Client cliente) {
        this.clientes.remove(cliente);
    }

    public void visualizarDadosCliente(Client cliente) {
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getTelefone());
    }

    public void editarDadosCliente(Client cliente, String novoNome, String novoEmail, String novaSenha,
            String novoTelefone) {
        if (this.clientes.contains(cliente)) {
            cliente.setNome(novoNome);
            cliente.setEmail(novoEmail);
            cliente.setSenha(novaSenha);
            cliente.setTelefone(novoTelefone);
        } else {
            System.out.println("O cliente " + cliente.getNome() + " não está cadastrado.");
        }
    }
}