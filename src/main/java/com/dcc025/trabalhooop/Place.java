package com.dcc025.trabalhooop;

import java.util.*;

public class Place {

	private String name;

	private HashMap<String, Double> produtos;

	public Place(String name) {
		this.name = name;
		this.produtos = new HashMap<String, Double>();
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

	public void addProdutos(Produto produtos) {
		this.produtos.put(produtos.getName(), produtos.getPrice());
	}

	public void printProdutos() {
		for (String produto : produtos.keySet()) {
			System.out.println(produto + ": $" + produtos.get(produto));
		}
	}

}
