package com.dcc025.trabalhooop;

import java.util.Vector;

public class Place {

	private String name;

	private Vector<Servicos> produtos;

	public Place(String name) {
		this.name = name;
		this.produtos = new Vector<Servicos>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Servicos> getProdutos() {
		return produtos;
	}

}
