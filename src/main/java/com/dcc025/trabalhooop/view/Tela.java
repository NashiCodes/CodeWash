package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.controller.CadastroController;
import com.dcc025.trabalhooop.controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {

    private JTextField tfEmail; //Cria um novo JTextField para o email
    private JPasswordField tfSenha; //Cria um novo JPasswordField para a senha
    private final int WIDTH = 500;  //Define a largura da janela
    private final int HEIGHT = 500; //Define a altura da janela

    private final int V_GAP = 10; //Define o espaçamento vertical
    private final int H_GAP = 5; //Define o espaçamento horizontal

    public Tela() {
        super("Sistema de Lava-Jatos"); //Instancia o JFrame com o título "Sistema de Lava-Jatos"
    }

    public void display() {
        setSize(WIDTH, HEIGHT); //Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Define a ação padrão ao fechar a janela
        setVisible(true); //Define a janela como visível

        telaLogin(); //Chama o método telaLogin

        pack(); //Redimensiona a janela para que todos os componentes sejam exibidos
    }

    private void telaLogin() {
        JPanel painel = new JPanel(); //Cria um novo JPanel para o login
        painel.setBorder(BorderFactory.createTitledBorder("Login")); //Define a borda do JPanel como "Login"

        JPanel login = new JPanel(); //Cria um novo JPanel para o login (dentro do JPanel "painel")
        JPanel painelLabel = new JPanel(); //Cria um novo JPanel para os labels (dentro do JPanel "login")
        painelLabel.setLayout(new GridLayout(0, 1, H_GAP, V_GAP)); //Define o layout do JPanel "painelLabel" como GridLayout
        painelLabel.add(new JLabel("Email")); //Adiciona um novo JLabel com o texto "Email" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Senha")); //Adiciona um novo JLabel com o texto "Senha" ao JPanel "painelLabel"

        JPanel painelField = new JPanel(); //Cria um novo JPanel para os campos (dentro do JPanel "login")
        painelField.setLayout(new GridLayout(0, 1, H_GAP, V_GAP)); //Define o layout do JPanel "painelField" como GridLayout
        tfEmail = new JTextField(20); //Cria um novo JTextField com 20 colunas de tamanho
        tfSenha = new JPasswordField(20); //Cria um novo JPasswordField com 20 colunas de tamanho

        painelField.add(tfEmail); //Adiciona o JTextField "tfEmail" ao JPanel "painelField"
        painelField.add(tfSenha); //Adiciona o JPasswordField "tfSenha" ao JPanel "painelField"

        login.add(painelLabel); //Adiciona o JPanel "painelLabel" ao JPanel "login" (dentro do JPanel "painel")
        login.add(painelField); //Adiciona o JPanel "painelField" ao JPanel "login" (dentro do JPanel "painel")

        painel.setLayout(new BorderLayout()); //Define o layout do JPanel "painel" como BorderLayout
        painel.add(login, BorderLayout.CENTER); //Adiciona o JPanel "login" ao JPanel "painel" (dentro do JPanel "painel") com o posicionamento CENTER

        JButton btnLogin = new JButton("Login"); //Cria um novo JButton com o texto "Login"
        btnLogin.addActionListener(new LoginController(this)); //Adiciona um novo ActionListener ao JButton "btnLogin"

        JButton btnCadastro = new JButton("Cadastrar"); //Cria um novo JButton com o texto "Cadastrar"
        btnCadastro.addActionListener(new CadastroController(this)); //Adiciona um novo ActionListener ao JButton "btnCadastro"

        JPanel botoes = new JPanel(); //Cria um novo JPanel para os botões
        botoes.add(btnLogin); //Adiciona o JButton "btnLogin" ao JPanel "botoes"
        botoes.add(btnCadastro); //Adiciona o JButton "btnCadastro" ao JPanel "botoes"

        painel.add(botoes, BorderLayout.SOUTH); //Adiciona o JPanel "botoes" ao JPanel "painel" com o posicionamento SOUTH

        this.getContentPane().add(painel, BorderLayout.CENTER); //Adiciona o JPanel "painel" ao JFrame com o posicionamento CENTER
    }

    private void telaCadastro() {
        // TODO: Implementar tela de cadastro (com os campos necessários para o cadastro)
    }

    public void login() {
        // TODO: Implementar o fetch de login
        // e chama seus respectivos métodos de acordo com o tipo de usuário
    }

    public void cadastro() {
        // TODO: Implementar o push de cadastro
        // e chama seus respectivos métodos de acordo com o tipo de usuário
    }


    public void editarDados() {
        // TODO: Implementar editar dados
    }

}
