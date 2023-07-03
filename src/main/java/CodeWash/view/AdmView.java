package CodeWash.view;

import CodeWash.controller.User.UserManager;
import CodeWash.model.Dias;
import CodeWash.model.Place;
import CodeWash.model.Produto;
import CodeWash.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//Classe que representa a tela do administrador e seus métodos
public class AdmView extends UserView {
    private final Dimension preferredSize = new Dimension(450, 400);
    private final Usuario user;
    private Place place;
    private JTextField JNome;
    private JTextField JPreco;
    // Cadastro de Lava Jato
    private final List<Dias> dias;
    private List<String> horarios;
    private JList<Produto> Jprodutos;

    public AdmView(Usuario user) {
        //Função que cria a tela do administrador
        super("Administrador"); //Título da tela
        this.user = user;    //Usuário que está logado
        this.dias = new ArrayList<>();  //Lista de dias
        this.horarios = new ArrayList<>();  //Lista de horários
        this.Jprodutos = new JList<>();  //Lista de produtos
        this.setSize(preferredSize);    //Tamanho da tela
        this.addWindowListener(new UserManager(this));  //Adiciona um listener para o botão de fechar a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Fecha a aplicação quando a tela é fechada
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y); //Posição da tela
        this.setVisible(true);  //Torna a tela visível
        this.setEnabled(true);  //Torna a tela habilitada
    }

    @Override
    public void display() {
        telaInicial();
        this.pack();
    }

    @Override
    public void carregaPlaces(List<Place> places) {
        //Função que carrega os lava jatos associados ao usuário
        for (Place place : places) {   //Percorre a lista de lava jatos
            if (place.getEmail().equals(user.getEmail())) {   //Verifica se o email do usuário é igual ao email do lava jato
                this.place = place; //Se sim, o lava jato é carregado
                break; //Para o loop
            }
        }
    }

    public void telaInicial() {
        //TODO: Implementar tela de cadastro dos lava jatos
        //verifica se o usuário já tem um Lava jato associado a ele
        if (this.place == null) {
            //se não, exibe um aviso de boas vindas e abre a tela de cadastro do lava jato
            telaCadastroLavaJato();
        } else {
            //se sim, abre a tela de edição do lava jato, como os horários de funcionamento, edição de produtos e serviços, etc
            AreaAdmin();
        }
    }

    public void telaCadastroLavaJato() {
        this.getContentPane().removeAll();
        //Jframe e Jpanel variáveis
        JLabel lblNome = new JLabel("Digite o nome do Lava Jato");
        JNome = new JTextField(20);
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> CadastraLavaJato());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cadastro de Lava Jato");
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lblNome, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(JNome, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(btnCadastrar, constraints);

        getContentPane().add(panel);
        pack();
    }

    private void getDias() {
        this.getContentPane().removeAll();
        setTitle("Selecione os dias de funcionamento");
        setSize(preferredSize);

        JPanel panel = new JPanel(new GridBagLayout());

        JPanel diasPanel = new JPanel(new GridBagLayout());
        diasPanel.setBorder(BorderFactory.createTitledBorder("Dias de funcionamento"));
        diasPanel.setPreferredSize(new Dimension(300, 200));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        for (int i = 0; i < 7; i++) {
            JCheckBox check = new JCheckBox(Dias.values()[i].toString());
            int finalI = i;
            check.addActionListener(e -> {
                if (check.isSelected()) {
                    dias.add(Dias.values()[finalI]);
                } else {
                    dias.remove(Dias.values()[finalI]);
                }
            });
            constraints.gridx = 0;
            constraints.gridy = i + 1;
            diasPanel.add(check, constraints);
        }

        JButton submit = new JButton("Continuar");
        submit.addActionListener(e -> {
            this.place.setDiasAbertos(dias);
            setHorarioFuncionamento();
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(diasPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(submit, constraints);

        this.getContentPane().add(panel);
        this.pack();
    }

    public void AreaAdmin() {
        this.getContentPane().removeAll();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Área Adminstrativa");
        setSize(300, 150);
        setLocationRelativeTo(null);

        //horarios
        JButton horarios = new JButton("Horários");
        horarios.addActionListener(e -> ListaHorarios());
        //editar produtos
        JButton produtos = new JButton("Editar produtos");
        produtos.addActionListener(e -> EditaProdutos());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        JLabel titulo = new JLabel("Selecione uma opção:");

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titulo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(horarios, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(produtos, constraints);


        getContentPane().add(panel);

        pack();
    }

    private void setHorarioFuncionamento() {
        this.getContentPane().removeAll();
        setTitle("Selecione os dias de funcionamento");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);


        panel.add(PainelHorarios(), constraints);

        JButton submit = new JButton("Continuar");
        submit.addActionListener(e -> {
            this.place.setDiasAbertos(dias);
            AreaAdmin();
        });

        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(submit, constraints);

        this.getContentPane().add(panel);
        this.pack();
    }

    private JPanel PainelHorarios() {
        JPanel horarios = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsHorarios = new GridBagConstraints();
        constraintsHorarios.fill = GridBagConstraints.HORIZONTAL;
        constraintsHorarios.insets = new Insets(5, 10, 5, 10);

        JLabel lblAbertura = new JLabel("Horário de Abertura");
        JLabel lblIntervalo = new JLabel("Horário de Intervalo");
        JLabel lblFechamento = new JLabel("Horário de Fechamento");

        JSpinner spnAbertura = new JSpinner(new SpinnerDateModel());
        JSpinner spnIntervalo = new JSpinner(new SpinnerDateModel());
        JSpinner spnFechamento = new JSpinner(new SpinnerDateModel());

        JSpinner.DateEditor deAbertura = new JSpinner.DateEditor(spnAbertura, "HH");
        JSpinner.DateEditor deIntervalo = new JSpinner.DateEditor(spnIntervalo, "HH");
        JSpinner.DateEditor deFechamento = new JSpinner.DateEditor(spnFechamento, "HH");

        spnAbertura.setEditor(deAbertura);
        spnIntervalo.setEditor(deIntervalo);
        spnFechamento.setEditor(deFechamento);

        constraintsHorarios.gridx = 0;
        constraintsHorarios.gridy = 0;
        horarios.add(lblAbertura, constraintsHorarios);

        constraintsHorarios.gridx = 1;
        constraintsHorarios.gridy = 0;
        horarios.add(spnAbertura, constraintsHorarios);

        constraintsHorarios.gridx = 0;
        constraintsHorarios.gridy = 1;
        horarios.add(lblIntervalo, constraintsHorarios);

        constraintsHorarios.gridx = 1;
        constraintsHorarios.gridy = 1;
        horarios.add(spnIntervalo, constraintsHorarios);

        constraintsHorarios.gridx = 0;
        constraintsHorarios.gridy = 2;
        horarios.add(lblFechamento, constraintsHorarios);

        constraintsHorarios.gridx = 1;
        constraintsHorarios.gridy = 2;
        horarios.add(spnFechamento, constraintsHorarios);

        return horarios;
    }

    private void ListaHorarios() {
        //TODO
    }

    private void EditaProdutos() {
        this.setLayout(new GridLayout(0, 2, 0, 0));
        this.getContentPane().removeAll();

        desenhaLista();
        desenhaFormulario();

        this.pack();
    }

    private void desenhaFormulario() {
        JPanel MainPanel = new JPanel();
        MainPanel.setBorder(BorderFactory.createTitledBorder("Edição de Produtos"));


        JPanel formulario = new JPanel();
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, 5, 10));
        painelLabel.add(new JLabel("Nome"));
        painelLabel.add(new JLabel("Preço"));


        JPanel painelField = new JPanel();
        painelField.setLayout(new GridLayout(0, 1, 5, 10));
        JNome = new JTextField(20);
        JPreco = new JTextField(20);

        painelField.add(JNome);
        painelField.add(JPreco);

        formulario.add(painelLabel);
        formulario.add(painelField);

        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(formulario, BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(e -> this.addProduto());

        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(e -> this.removerProduto());

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> this.editarProduto());

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> this.AreaAdmin());

        JPanel botoes = new JPanel();
        botoes.add(btnAdicionar);
        botoes.add(btnRemover);
        botoes.add(btnEditar);
        botoes.add(btnVoltar);

        MainPanel.add(botoes, BorderLayout.SOUTH);

        this.getContentPane().add(MainPanel, BorderLayout.CENTER);

    }

    private void desenhaLista() {
        JPanel MainPanel = new JPanel();
        MainPanel.setBorder(BorderFactory.createTitledBorder("Produtos"));
        MainPanel.setLayout(new BorderLayout());

        DefaultListModel<Produto> model = new DefaultListModel<>();


        Jprodutos = new JList<>(model);
        Jprodutos.addListSelectionListener(event -> this.AtualizaFormulario());
        AtualizaLista();

        MainPanel.add(new JScrollPane(Jprodutos), BorderLayout.CENTER);

        this.getContentPane().add(MainPanel, BorderLayout.WEST);

    }

    private void AtualizaFormulario() {
        int index = Jprodutos.getSelectedIndex();
        if (index != -1) {
            DefaultListModel<Produto> model = (DefaultListModel<Produto>) Jprodutos.getModel();
            Produto produto = model.get(index);
            JNome.setText(produto.getNome());
            JPreco.setText(String.valueOf(produto.getPreco()));
        }


    }

    private void AtualizaLista() {
        DefaultListModel<Produto> model = (DefaultListModel<Produto>) Jprodutos.getModel();
        model.clear();
        for (Produto produto : this.place.getProdutos()) {
            model.addElement(produto);
        }
    }

    private void addProduto() {
        String nome = JNome.getText();
        double preco = Double.parseDouble(JPreco.getText());
        this.place.addProduto(nome, preco);
         this.AtualizaLista();
    }

    private void removerProduto() {
        int index = Jprodutos.getSelectedIndex();
        this.place.removerProduto(index);
        this.AtualizaLista();
    }

    private void editarProduto() {
        int index = Jprodutos.getSelectedIndex();
        String nome = JNome.getText();
        double preco = Double.parseDouble(JPreco.getText());
        this.place.editarProduto(index, nome, preco);
        this.AtualizaLista();
    }

    public void CadastraLavaJato() {
        place = new Place(JNome.getText(), user.getEmail());
        getDias();
    }

    @Override
    public List<Place> listPlaces(List<Place> places) {
        //Função que lista os lava jatos associados ao usuário
        places.removeIf(place -> place.getEmail().equals(user.getEmail()));//Remove o Lava jato do usuário da lista para atualizar
        places.add(this.place); //Adiciona o lava jato do usuário na lista
        return places; //Retorna a lista
    }

    @Override
    public void itemSelected() {
        //Função que é chamada quando um item é selecionado
    }
}
