package com.dcc025.trabalhooop;

import java.util.*;

public class sistemaLJ {

	private static final List<Place> places = new ArrayList<>();
	private static final Scanner scan = new Scanner(System.in);
	private static Usuario usuario;
	private static final List<Cadastro> cadastro = new ArrayList<Cadastro>();
	private static String option;
	private static boolean logado = false;

	private static String leitor() {
		String nome = scan.nextLine();
		return nome;
	}

	public static void main(String[] args) {
		option = "1";
		menu();
	}

	private static void menu() {
		while (!"-1".equals(option)) {
			menuOptions();
			option = leitor();
			seletor();
		}
	}

	private static void menuOptions() {
		System.out.println("//----------------------------------------------------------------//");
		System.out.println("		Bem vindo ao SistemaLJ, o que deseja fazer?");

		if (!logado) {
			System.out.println("(1)Cadastre-se");
			System.out.println("(2)login");
		} else {
			System.out.println("	(1) Cadastrar seu Lava Jato");
			System.out.println("	(2) Cadastrar um novo serviço");
		}

		System.out.println("	(-1) Sair");
		System.out.println("//----------------------------------------------------------------//");
	}

	public static void seletor() {
		if (logado) {
			switch (option) {
				case "1":
					novoLJ();
					break;
				case "2":
					novoProduto();
				default:
					break;
			}
		} else {
			switch (option) {
				case "1":
					cadastrar();
					break;
				case "2":
					login();
				default:
					break;
			}
		}
	}

	public static void novoLJ() {
		System.out.println("Digite o nome do seu Lava Jato:");
		String nome = leitor();
		places.add(new Place(nome));
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
			} else if (places.indexOf(place) == places.size() - 1) {
				System.out.println("Não foi possivel adicionar o Produto");
				break;
			}

		}

	}

	public static void cadastrar() {
		menuCadastro();
		cadastro.add(new Cadastro(usuario.getEmail(), usuario.getSenha(cadastro), usuario.getClass().getName()));
		logado = true;
	}

	public static void menuCadastro() {
		System.out.println("Digite seu nome: ");
		String nome = leitor();
		System.out.println("Digite seu telefone: ");
		String telefone = leitor();
		System.out.println("Digite o nome do seu email:");
		String email = leitor();
		System.out.println("Digite o nome do sua senha:");
		String senha = leitor();
		System.out.println("(0)Cliente ou (1)Administrador:");
		String tipoUser = leitor();
		switch (tipoUser) {
			case "0":
				usuario = new Client(nome, telefone, email, senha);
				break;
			case "1":
				usuario = new Administrador(nome, telefone, email, senha);
				break;
			default:
				break;
		}
	}

	public static void seletorCad(String tipoUser) {
	}

	public static void login() {

	}

}
