package com.dcc025.trabalhooop;

import java.util.*;

public class sistemaLJ {

	private static List<Place> places = new ArrayList<Place>();
	private static String option;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		option = "1";
		menu();
	}

	private static void menu() {
		while (option != "-1") {
			menuOptions();
			option = leitorOptions();
			seletor();
		}
	}

	private static String leitorOptions() {
		option = scan.nextLine();
		return option;
	}

	private static void menuOptions() {
		if (places.isEmpty()) {
			System.out.println("//----------------------------------------------------------------//");
			System.out.println("			Bem vindo ao SistemaLJ, o que deseja fazer?");
			System.out.println("	(1) Cadastrar seu Lava Jato");
			System.out.println("	(-1) Sair");
		} else
			System.out.println("	(2) Cadastrar um novo serviço");

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
		System.out.println("Digite o nome do seu Lava Jato: ");
		String nome = leitorString();
		places.add(new Place(nome));
		for (Place place : places) {
			System.out.println(place.getName());
		}
	}

	public static void novoProduto() {

	}

	private static String leitorString() {
		String nome = scan.nextLine();
		return nome;
	}

}
