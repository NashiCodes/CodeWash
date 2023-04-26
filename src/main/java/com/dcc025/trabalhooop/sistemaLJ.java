package com.dcc025.trabalhooop;

import java.util.*;

public class sistemaLJ {

	private static Vector<Place> places = new Vector<Place>();

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("//----------------------------------------------------------------//");
			System.out.println("			Bem vindo ao SistemaLJ, o que deseja fazer?");
			System.out.println("	(1) Cadastrar seu Lava Jato");
			System.out.println("	(2) Cadastrar um novo serviço");
			System.out.println("	(-1) Sair");
			System.out.println("//----------------------------------------------------------------//");
			int option = scan.nextInt();
			seletor(option);
			option = scan.nextInt();
			while (option != -1) {
				seletor(option);
				option = scan.nextInt();
			}
		}

	}

	public static void seletor(int option) {
		switch (option) {
			case 1:
				novoLJ();
				break;
			case 2:
				novoProduto();
			case -1:
				break;
		}
	}

	public static void novoLJ() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Digite o nome do seu Lava Jato: ");
			final String nome = scan.nextLine();
			scan.close();
			places.addElement(new Place(nome));
		}
	}

	public static void novoProduto() {

	}

}
