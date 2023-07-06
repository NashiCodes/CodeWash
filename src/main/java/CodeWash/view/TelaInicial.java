// NOME: Gabriel de Oliveira Vieira                       MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                         MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                    MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package CodeWash.view;

import CodeWash.controller.TelaInicial.CadastroController;
import CodeWash.controller.TelaInicial.LoginController;
import CodeWash.controller.TelaInicial.TelaManager;
import CodeWash.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TelaInicial extends JFrame {

    private JTextField tfNome; //Cria um novo JTextField para o nome
    private JTextField tfEmail; //Cria um novo JTextField para o email
    private JPasswordField tfSenha; //Cria um novo JPasswordField para a senha
    private JPasswordField tfConfirmarSenha; //Cria um novo JPasswordField para a confirmação de senha
    private final String[] tiposUsuario = {"Cliente", "Administrador"}; //Cria um novo array de String com os tipos de usuário
    private final JComboBox<String> cbTipoUsuario = new JComboBox<>(tiposUsuario); //Cria um novo JComboBox com os tipos de usuário

    private final int WIDTH = 500;  //Define a largura da janela
    private final int HEIGHT = 500; //Define a altura da janela

    private final int V_GAP = 10; //Define o espaçamento vertical
    private final int H_GAP = 5; //Define o espaçamento horizontal
    private Usuario usuarioLogado; //Cria um novo objeto do tipo Usuario para o usuário logado
    private List<Usuario> usuarios; //Cria um novo ArrayList de Usuario para os usuários cadastrados

    public TelaInicial() {
        super("CodeWash"); //Instancia o JFrame com o título "Sistema de Lava-Jatos"
        usuarios = new ArrayList<>(); //Instancia o ArrayList de Usuario
    }

    public void display() {
        this.getContentPane().removeAll(); //Remove todos os componentes do JFrame
        setSize(WIDTH, HEIGHT); //Define o tamanho da janela
        addWindowListener(new TelaManager(this)); //Adiciona um novo WindowListener à janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Define a ação padrão ao fechar a janela
        setResizable(false); //Define que a janela não pode ser redimensionada
        setVisible(true); //Define a janela como visível

        telaLogin(); //Chama o método telaLogin

        pack(); //Redimensiona a janela para que todos os componentes sejam exibidos
        setLocationRelativeTo(null); //Define que a janela será centralizada na tela
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
        btnCadastro.addActionListener(new CadastroController(this, false, null)); //Adiciona um novo ActionListener ao JButton "btnCadastro"

        JPanel botoes = new JPanel(); //Cria um novo JPanel para os botões
        botoes.add(btnLogin); //Adiciona o JButton "btnLogin" ao JPanel "botoes"
        botoes.add(btnCadastro); //Adiciona o JButton "btnCadastro" ao JPanel "botoes"

        painel.add(botoes, BorderLayout.SOUTH); //Adiciona o JPanel "botoes" ao JPanel "painel" com o posicionamento SOUTH

        this.getContentPane().add(painel, BorderLayout.CENTER); //Adiciona o JPanel "painel" ao JFrame com o posicionamento CENTER
    }

    public void telaCadastro() {
        JFrame frame = new JFrame("Cadastre - se"); //Instancia um novo JFrame com o título "Cadastro"
        frame.setSize(WIDTH, HEIGHT); //Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Define a ação padrão ao fechar a janela
        frame.setVisible(true); //Define a janela como visível

        JPanel painel = new JPanel(); //Cria um novo JPanel para o cadastro
        painel.setBorder(BorderFactory.createTitledBorder("Cadastro")); //Define a borda do JPanel como "Cadastro"

        JPanel cadastro = new JPanel(); //Cria um novo JPanel para o cadastro (dentro do JPanel "painel")
        JPanel painelLabel = new JPanel(); //Cria um novo JPanel para os labels (dentro do JPanel "cadastro")
        painelLabel.setLayout(new GridLayout(0, 1, H_GAP, V_GAP + 10)); //Define o layout do JPanel "painelLabel" como GridLayout
        painelLabel.add(new JLabel("Nome")); //Adiciona um novo JLabel com o texto "Nome" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Email")); //Adiciona um novo JLabel com o texto "Email" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Senha")); //Adiciona um novo JLabel com o texto "Senha" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Confirmar Senha")); //Adiciona um novo JLabel com o texto "Confirmar Senha" ao JPanel "painelLabel"
        painelLabel.add(new JLabel("Tipo de Usuário")); //Adiciona um novo JLabel com o texto "Tipo de Usuário" ao JPanel "painelLabel"

        JPanel painelField = new JPanel(); //Cria um novo JPanel para os campos (dentro do JPanel "cadastro")
        painelField.setLayout(new GridLayout(0, 1, H_GAP, V_GAP)); //Define o layout do JPanel "painelField" como GridLayout
        tfNome = new JTextField(20); //Cria um novo JTextField com 20 colunas de tamanho
        tfEmail = new JTextField(20); //Cria um novo JTextField com 20 colunas de tamanho
        tfSenha = new JPasswordField(20); //Cria um novo JPasswordField com 20 colunas de tamanho
        tfConfirmarSenha = new JPasswordField(20); //Cria um novo JPasswordField com 20 colunas de tamanho

        painelField.add(tfNome); //Adiciona o JTextField "tfNome" ao JPanel "painelField"
        painelField.add(tfEmail); //Adiciona o JTextField "tfEmail" ao JPanel "painelField"
        painelField.add(tfSenha); //Adiciona o JPasswordField "tfSenha" ao JPanel "painelField"
        painelField.add(tfConfirmarSenha); //Adiciona o JPasswordField "tfConfirmarSenha" ao JPanel "painelField"
        painelField.add(cbTipoUsuario); //Adiciona o JComboBox "cbTipoUsuario" ao JPanel "painelField"

        cadastro.add(painelLabel); //Adiciona o JPanel "painelLabel" ao JPanel "cadastro" (dentro do JPanel "painel")
        cadastro.add(painelField); //Adiciona o JPanel "painelField" ao JPanel "cadastro" (dentro do JPanel "painel")

        painel.setLayout(new BorderLayout()); //Define o layout do JPanel "painel" como BorderLayout
        painel.add(cadastro, BorderLayout.CENTER); //Adiciona o JPanel "cadastro" ao JPanel "painel" (dentro do JPanel "painel") com o posicionamento CENTER

        JButton btnCadastrar = new JButton("Cadastrar"); //Cria um novo JButton com o texto "Cadastrar"
        btnCadastrar.addActionListener(new CadastroController(this, true, frame)); //Adiciona um novo ActionListener ao JButton "btnCadastrar"

        JButton btnCancelar = new JButton("Cancelar"); //Cria um novo JButton com o texto "Cancelar"
        btnCancelar.addActionListener(e -> {
            frame.dispose(); //Fecha a janela
            frame.setEnabled(false); //Desabilita a janela
            this.setEnabled(true); //Habilita a janela
            this.display();
        });

        JPanel botoes = new JPanel(); //Cria um novo JPanel para os botões
        botoes.add(btnCadastrar); //Adiciona o JButton "btnCadastrar" ao JPanel "botoes"
        botoes.add(btnCancelar); //Adiciona o JButton "btnCancelar" ao JPanel "botoes"

        painel.add(botoes, BorderLayout.SOUTH); //Adiciona o JPanel "botoes" ao JPanel "painel" com o posicionamento SOUTH

        frame.getContentPane().add(painel, BorderLayout.CENTER); //Adiciona o JPanel "painel" ao JFrame com o posicionamento CENTER

        frame.pack(); //Redimensiona a janela
        frame.setLocationRelativeTo(null); //Define que a janela será centralizada na tela
    }

    public void login() {
        for (Usuario usuario : usuarios)
            if (usuario.getEmail().equals(tfEmail.getText()) && usuario.getSenha().equals(new String(tfSenha.getPassword())))
                this.usuarioLogado = usuario;


        if (usuarioLogado != null) {
            JOptionPane.showMessageDialog(null, "Login efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            handleUser();
        } else
            JOptionPane.showMessageDialog(null, "Email ou senha incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void cadastro(JFrame frame) {
        if (Arrays.equals(tfSenha.getPassword(), tfConfirmarSenha.getPassword()))  //Se a senha e a confirmação de senha forem iguais
        {
            usuarioLogado = atribuiUsuario(); //Atribui os valores dos campos de texto ao usuário logado
            usuarios.add(usuarioLogado); //Adiciona um novo usuário à lista de usuários
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE); //Exibe uma mensagem de sucesso
            frame.dispose(); //Fecha a janela
            handleUser();

        } else
            JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Erro", JOptionPane.ERROR_MESSAGE); //Exibe uma mensagem de erro

    }

    public void carregaUsuarios(List<Usuario> usuarios) {
        if (this.usuarios.isEmpty()) this.usuarios = usuarios;
        else for (Usuario u : usuarios)
            if (!this.usuarios.contains(u)) this.usuarios.add(u);
            else this.usuarios.add(u);
    }

    private void handleUser() {
        if (usuarioLogado.getTipo()) {
            this.dispose();
            new AdmView(usuarioLogado,this);
        } else {
            this.dispose();
            new ClienteView(usuarioLogado,this);
        }
    }

    private boolean verificaTipo() {
        return Objects.equals(cbTipoUsuario.getSelectedItem(), "Administrador");
    }

    private Usuario atribuiUsuario() {
        if (verificaTipo())
            return new Usuario(tfNome.getText(), tfEmail.getText(), new String(tfSenha.getPassword()), true);
        else
            return new Usuario(tfNome.getText(), tfEmail.getText(), new String(tfSenha.getPassword()), false);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}
