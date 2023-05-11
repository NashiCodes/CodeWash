// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package com.dcc025.trabalhooop;

import java.util.*;

public class Administrador extends Usuario {
    private HashMap<String, Double> produtos;
    private ArrayList<Client> clientes;
    private Horario horarios;

    public Administrador(String nome, String telefone, String email, String senha) {
        super(nome, telefone, email, senha);
        this.produtos = new HashMap<String, Double>();
        this.horarios = new Horario(0);
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

    public void mostrarHorarios() {
        System.out.println("Horarios");
        for (int i = 0; i < diasUteis(); i++) {
            String diaSemana = this.horarios.nomeDia(i);
            System.out.println(diaSemana + ": ");
            this.horarios.printDia(i);
        }
    }

    public int diasUteis() {
        return this.horarios.getDiasUteis();
    }

    public void Funcionamento(int i) {
        this.horarios.setDiasUteis(i);
    }

}