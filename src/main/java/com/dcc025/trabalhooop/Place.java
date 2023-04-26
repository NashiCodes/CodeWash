package com.dcc025.trabalhooop;

import java.util.Vector;

public class Place {

	private String name;

	private Vector<Produtos> produtos;

	public Place(String name) {
		this.name = name;
		this.produtos = new Vector<Produtos>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Produtos> getProdutos() {
		return produtos;
	}

}
