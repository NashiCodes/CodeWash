// NOME: Gabriel de Oliveira Vieira                               MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                                 MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                        MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package com.dcc025.trabalhooop.model;

import java.util.*;

public class Place {

    private String name;

    private HashMap<String, Double> produtos;

    public Place(String name) {
        this.name = name;
        this.produtos = new HashMap<>();
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

    public void addProdutos(String name, double price) {
        this.produtos.put(name, price);
    }

    public void printProdutos() {
        for (String produto : produtos.keySet()) {
            System.out.println(produto + ": $" + produtos.get(produto));
        }
    }

}
