package com.dcc025.trabalhooop;

import java.util.*;

public class sistemaLJ {

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
			while (option != -1) {
				seletor(option);
				option = scan.nextInt();
			}
		}

	}

	public static void seletor(int option) {
		switch (option) {
			case 1:
				NovoLJ();
				break;
			case 2:
				NovoProduto();
			default:
				break;
		}
	}

	public static void NovoLJ() {

	}

	public static void NovoProduto() {

	}
}
