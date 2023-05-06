package com.dcc025.trabalhooop;

import java.util.*;

public class sistemaLJ {

	private static List<Place> places = new ArrayList<Place>();
	private static String option;
	private static Scanner scan = new Scanner(System.in);

	private static String leitor() {
		String nome = scan.nextLine();
		return nome;
	}

	public static void main(String[] args) {
		option = "1";
		menu();
	}

	private static void menu() {
		while (option != "-1") {
			menuOptions();
			option = leitor();
			seletor();
		}
	}

	private static void menuOptions() {
		System.out.println("//----------------------------------------------------------------//");
		System.out.println("		Bem vindo ao SistemaLJ, o que deseja fazer?");
		System.out.println("	(1) Cadastrar seu Lava Jato");

		if (!places.isEmpty())
			System.out.println("	(2) Cadastrar um novo serviço");

		System.out.println("	(-1) Sair");
		System.out.println("//----------------------------------------------------------------//");
	}

	public static void seletor() {
		switch (option) {
			case "1":
				novoLJ();
				break;
			case "2":
				novoProduto();
			case "-1":
				break;
		}
	}

	public static void novoLJ() {
		System.out.println("Digite o nome do seu Lava Jato:");
		String nome = leitor();
		places.add(new Place(nome));
		for (Place place : places) {
			System.out.println(place.getName());
		}
	}

	public static void novoProduto() {
		System.out.println("Digite o nome do seu Lava Jato:");
		String nome = leitor();
		for (Place place : places) {
			if (place.getName().equals(nome)) {
				System.out.println("Digite o nome do seu produto:");
				nome = leitor();
				System.out.println("Digite o preço do seu produto:");
				String preço = leitor();
				place.addProdutos(new Servicos(nome, Integer.parseInt(preço)));
				break;
			} else if (places.indexOf(place) == places.size() - 1)
				System.out.println("Não foi possivel adicionar o Produto");
			break;
		}

	}
}
