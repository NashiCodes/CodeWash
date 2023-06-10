package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.controller.*;
import com.dcc025.trabalhooop.model.Usuario;
import com.dcc025.trabalhooop.persistence.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tela extends JFrame {

    private JTextField tfNome; //Cria um novo JTextField para o nome
    private JTextField tfTelefone; //Cria um novo JTextField para o telefone
    private JTextField tfEmail; //Cria um novo JTextField para o email
    private JPasswordField tfSenha; //Cria um novo JPasswordField para a senha
    private JPasswordField tfConfirmarSenha; //Cria um novo JPasswordField para a confirmação de senha
    private final String[] tiposUsuario = {"Cliente", "Administrador"}; //Cria um novo array de String com os tipos de usuário
    private final JComboBox<String> cbTipoUsuario = new JComboBox<>(tiposUsuario); //Cria um novo JComboBox com os tipos de usuário

    private final int WIDTH = 500;  //Define a largura da janela
    private final int HEIGHT = 500; //Define a altura da janela

    private final int V_GAP = 10; //Define o espaçamento vertical
    private final int H_GAP = 5; //Define o espaçamento horizontal
    private JList<Usuario> listUsuarios;

    public Tela() {
        super("Sistema de Lava-Jatos"); //Instancia o JFrame com o título "Sistema de Lava-Jatos"
    }

    public void display() {
        setSize(WIDTH, HEIGHT); //Define o tamanho da janela
        addWindowListener(new TelaManager(this)); //Adiciona um novo WindowListener à janela
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

        JButton btnCadastro = new JButton("Cadastre-se"); //Cria um novo JButton com o texto "Cadastrar"
        btnCadastro.addActionListener(new CadastroController(this, false)); //Adiciona um novo ActionListener ao JButton "btnCadastro"

        JPanel botoes = new JPanel(); //Cria um novo JPanel para os botões
        botoes.add(btnLogin); //Adiciona o JButton "btnLogin" ao JPanel "botoes"
        botoes.add(btnCadastro); //Adiciona o JButton "btnCadastro" ao JPanel "botoes"

        painel.add(botoes, BorderLayout.SOUTH); //Adiciona o JPanel "botoes" ao JPanel "painel" com o posicionamento SOUTH

        this.getContentPane().add(painel, BorderLayout.CENTER); //Adiciona o JPanel "painel" ao JFrame com o posicionamento CENTER
    }

    public void telaCadastro() {
        // TODO: Implementar tela de cadastro (com os campos necessários para o cadastro)
        JFrame frame = new JFrame("Cadastro"); //Instancia um novo JFrame com o título "Cadastro"
        frame.setSize(WIDTH, HEIGHT); //Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Define a ação padrão ao fechar a janela
        frame.setVisible(true); //Define a janela como visível

        JPanel painel = new JPanel(); //Cria um novo JPanel para o cadastro
        painel.setBorder(BorderFactory.createTitledBorder("Cadastro")); //Define a borda do JPanel como "Cadastro"

        JPanel cadastro = new JPanel(); //Cria um novo JPanel para o cadastro (dentro do JPanel "painel")
        JPanel painelLabel = new JPanel(); //Cria um novo JPanel para os labels (dentro do JPanel "cadastro")
        painelLabel.setLayout(new GridLayout(0, 1, H_GAP, V_GAP + 10)); //Define o layout do JPanel "painelLabel" como GridLayout
        painelLabel.add(new JLabel("Nome")); //Adiciona um novo JLabel com o texto "Nome" ao JPanel "painelLabel"
        painelLabel.add((new JLabel("Telefone"))); //Adiciona um novo JLabel com o texto "Telefone" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Email")); //Adiciona um novo JLabel com o texto "Email" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Senha")); //Adiciona um novo JLabel com o texto "Senha" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Confirmar Senha")); //Adiciona um novo JLabel com o texto "Confirmar Senha" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Tipo de Usuário")); //Adiciona um novo JLabel com o texto "Tipo de Usuário" ao JPanel "painelLabel"

        JPanel painelField = new JPanel(); //Cria um novo JPanel para os campos (dentro do JPanel "cadastro")
        painelField.setLayout(new GridLayout(0, 1, H_GAP, V_GAP)); //Define o layout do JPanel "painelField" como GridLayout
        tfNome = new JTextField(20); //Cria um novo JTextField com 20 colunas de tamanho
        tfTelefone = new JTextField(20); //Cria um novo JTextField com 20 colunas de tamanho
        tfEmail = new JTextField(20); //Cria um novo JTextField com 20 colunas de tamanho
        tfSenha = new JPasswordField(20); //Cria um novo JPasswordField com 20 colunas de tamanho
        tfConfirmarSenha = new JPasswordField(20); //Cria um novo JPasswordField com 20 colunas de tamanho

        painelField.add(tfNome); //Adiciona o JTextField "tfNome" ao JPanel "painelField"
        painelField.add(tfTelefone); //Adiciona o JTextField "tfTelefone" ao JPanel "painelField"
        painelField.add(tfEmail); //Adiciona o JTextField "tfEmail" ao JPanel "painelField"
        painelField.add(tfSenha); //Adiciona o JPasswordField "tfSenha" ao JPanel "painelField"
        painelField.add(tfConfirmarSenha); //Adiciona o JPasswordField "tfConfirmarSenha" ao JPanel "painelField"
        painelField.add(cbTipoUsuario); //Adiciona o JComboBox "cbTipoUsuario" ao JPanel "painelField"

        cadastro.add(painelLabel); //Adiciona o JPanel "painelLabel" ao JPanel "cadastro" (dentro do JPanel "painel")
        cadastro.add(painelField); //Adiciona o JPanel "painelField" ao JPanel "cadastro" (dentro do JPanel "painel")

        painel.setLayout(new BorderLayout()); //Define o layout do JPanel "painel" como BorderLayout
        painel.add(cadastro, BorderLayout.CENTER); //Adiciona o JPanel "cadastro" ao JPanel "painel" (dentro do JPanel "painel") com o posicionamento CENTER

        JButton btnCadastrar = new JButton("Cadastrar"); //Cria um novo JButton com o texto "Cadastrar"
        btnCadastrar.addActionListener(new CadastroController(this, true)); //Adiciona um novo ActionListener ao JButton "btnCadastrar"

        JButton btnCancelar = new JButton("Cancelar"); //Cria um novo JButton com o texto "Cancelar"
        btnCancelar.addActionListener(e -> {
            frame.dispose(); //Fecha a janela
        });

        JPanel botoes = new JPanel(); //Cria um novo JPanel para os botões
        botoes.add(btnCadastrar); //Adiciona o JButton "btnCadastrar" ao JPanel "botoes"
        botoes.add(btnCancelar); //Adiciona o JButton "btnCancelar" ao JPanel "botoes"

        painel.add(botoes, BorderLayout.SOUTH); //Adiciona o JPanel "botoes" ao JPanel "painel" com o posicionamento SOUTH

        frame.getContentPane().add(painel, BorderLayout.CENTER); //Adiciona o JPanel "painel" ao JFrame com o posicionamento CENTER

        frame.pack(); //Redimensiona a janela
    }

    public void login() {
        // TODO: Implementar o fetch de login
        // e chama seus respectivos métodos de acordo com o tipo de usuário
    }

    public void cadastro() {
        // TODO: Implementar o push de cadastro
        // e chama seus respectivos métodos de acordo com o tipo de usuário
        DefaultListModel<Usuario> model = (DefaultListModel<Usuario>) listUsuarios.getModel(); //Cria um novo DefaultListModel para armazenar os usuários
        if (tfSenha == tfConfirmarSenha) {
            model.addElement(new Usuario(
                    tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), Arrays.toString(tfSenha.getPassword()),
                    Objects.equals(Objects.requireNonNull(cbTipoUsuario.getSelectedItem()).toString(), "Cliente")
            )); //Adiciona o usuário ao DefaultListModel
            listUsuarios.setModel(model); //Define o DefaultListModel como o modelo da JList "listUsuarios"
        } else JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void carregaUsuarios(List<Usuario> usuarios) {
        DefaultListModel<Usuario> model = new DefaultListModel<>(); //Cria um novo DefaultListModel para armazenar os usuários
        for (Usuario usuario : usuarios) { //Para cada usuário na lista de usuários
            model.addElement(usuario); //Adiciona o usuário ao DefaultListModel
        }
        listUsuarios.setModel(model); //Define o DefaultListModel como o modelo da JList "listUsuarios"
    }


    public void editarDados() {
        // TODO: Implementar editar dados
    }

}
