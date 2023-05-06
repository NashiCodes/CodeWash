package com.dcc025.trabalhooop;

import java.util.*;

public class Place {

	private String name;

	private final List<Servicos> produtos;

	public Place(String name) {
		this.name = name;
		this.produtos = new ArrayList<Servicos>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Servicos> getProdutos() {
		return produtos;
	}

	public void addProdutos(Servicos produtos) {
		this.produtos.add(produtos);
	}

	public void printProdutos() {
		for (Servicos servicos : produtos) {
			System.out.println(servicos.getName());
			System.out.println(servicos.getPrice() + "\n");
		}
	}

}
