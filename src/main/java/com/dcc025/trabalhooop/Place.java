package com.dcc025.trabalhooop;

import java.util.*;

public class Place {

	private String name;

	private List<Servicos> produtos;

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

}
