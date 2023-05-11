package com.dcc025.trabalhooop;

import java.util.*;

public class sistemaLJ {
	private static final List<Place> places = new ArrayList<Place>();
	private static final Scanner scan = new Scanner(System.in);
	private static final List<Cadastro> cadastro = new ArrayList<Cadastro>();
	private static Usuario user;
	private static Client client;
	private static Administrador adm;
	private static Place LavaJato;

	private static String option;

	private static String leitor() {
		String string = scan.nextLine();
		return string;
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
		limparTerminal();
		System.out.println("//----------------------------------------------------------------//");
		System.out.println("		Bem vindo ao SistemaLJ, o que deseja fazer?");
		System.out.println("(1)Cadastre-se");
		System.out.println("(2)login");
		System.out.println("(-1) Sair");
		System.out.println("//----------------------------------------------------------------//");
	}

	public static void seletor() {
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

	public static void cadastrar() {
		menuCadastro();
		cadastro.add(new Cadastro(user.getEmail(), user.getSenha(cadastro), user.getClass().getName()));
	}

	public static void login() {
	}

	public static void menuCadastro() {
		limparTerminal();
		System.out.println("Digite seu nome: ");
		String nome = leitor();
		System.out.println("Digite seu telefone: ");
		String telefone = leitor();
		System.out.println("Digite seu email:");
		String email = leitor();
		System.out.println("Digite sua senha:");
		String senha = leitor();
		System.out.println("(0)Cliente ou (1)Administrador:");
		String tipoUser = leitor();
		switch (tipoUser) {
			case "0":
				client = new Client(nome, telefone, email, senha);
				user = client;
				break;
			case "1":
				adm = new Administrador(nome, telefone, email, senha);
				user = adm;
				cadastraAdm();
				break;
			default:
				break;
		}
	}

	public static void cadastraAdm() {
		limparTerminal();
		System.out.println("Digite o nome do seu Lava Jato:");
		String nome = leitor();
		LavaJato = new Place(nome);
		places.add(LavaJato);
		limparTerminal();
		loopADM();
	}

	public static void optionsAdm() {
		limparTerminal();
		System.out.println("//----------------------------------------------------------------//");
		System.out.println("		        SistemaLJ, o que deseja fazer?");
		System.out.println("(1) Modificar Dias de funcionamento");
		if (adm.diasUteis() != 0) {
			System.out.println("(2) Vizualizar horarios");
			System.out.println("(3) Adicionar Produtos");
			System.out.println("(4) Editar preço de produto");
			System.out.println("(5) Vizualizar produtos");
		}
		System.out.println("(-1) Sair");
		System.out.println("//----------------------------------------------------------------//");
	}

	public static void loopADM() {
		while (!"-1".equals(option)) {
			optionsAdm();
			option = leitor();
			seletorAdm();
		}
		option = "0";
	}

	public static void seletorAdm() {
		switch (option) {
			case "1":
				limparTerminal();
				System.out.println("Digite quantos dias uteis seu Lava Jato irá Funcionar: ");
				adm.Funcionamento(Integer.parseInt(leitor()));
				break;
			case "2":
				adm.mostrarHorarios();
				leitor();
				break;
			case "3":
				novoProduto();
				break;
			case "4":
				limparTerminal();
				System.out.println("Digite o nome do produto que sera modificado : ");
				String nome = leitor();
				System.out.println("Digite seu novo preço: ");
				Double preço = Double.parseDouble(leitor());
				adm.editarPrecoProduto(nome, preço);
				break;
			case "5":
				limparTerminal();
				System.out.println("Não implementado ainda");
				break;
			default:
				break;
		}
	}

	public static void novoProduto() {
		limparTerminal();
		System.out.println("Digite o nome do seu produto:");
		String nome = leitor();
		System.out.println("Digite o preço do seu produto:");
		Double preço = Double.parseDouble(leitor());
		adm.adicionarProduto(nome, preço);
	}

	public static void limparTerminal() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			// Handle any exceptions here.
		}
	}
}
