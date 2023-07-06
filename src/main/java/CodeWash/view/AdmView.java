// NOME: Gabriel de Oliveira Vieira                       MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                         MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                    MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package CodeWash.view;

import CodeWash.controller.User.UserManager;
import CodeWash.exception.HorarioException;
import CodeWash.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//Classe que representa a tela do administrador e seus métodos
public class AdmView extends UserView {
    private final TelaInicial login;
    private final Dimension preferredSize = new Dimension(450, 400);
    private final Usuario user;
    private Place place;
    private JTextField JNome;
    private JTextField JPreco;
    private JTextField JQuantidade;
    // Cadastro de Lava Jato
    private final List<Dias> dias;
    private final List<Integer> horarios;
    private JList<Produto> Jprodutos;

    public AdmView(Usuario user, TelaInicial login) {
        // Função que cria a tela do administrador
        super("Administrador"); // Título da tela
        this.login = login; // Tela de login
        this.user = user; // Usuário que está logado
        this.dias = new ArrayList<>(); // Lista de dias
        this.horarios = new ArrayList<>(3); // Lista de horários
        this.Jprodutos = new JList<>(); // Lista de produtos
        this.setSize(preferredSize); // Tamanho da tela
        this.addWindowListener(new UserManager(this)); // Adiciona um listener para o botão de fechar a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação quando a tela é fechada
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y); // Posição da tela
        this.setVisible(true); // Torna a tela visível
        this.setEnabled(true); // Torna a tela habilitada
    }

    @Override
    public void display() {
        telaInicial();
        this.pack();
    }

    @Override
    public void carregaPlaces(List<Place> places) {
        // Função que carrega os lava jatos associados ao usuário
        for (Place place : places) { // Percorre a lista de lava jatos
            if (place.getEmail().equals(user.getEmail())) { // Verifica se o email do usuário é igual ao email do lava jato
                this.place = place; // Se sim, o lava jato é carregado
                break; // Para o loop
            }
        }
    }

    public void telaInicial() {
        if (this.place == null) telaCadastroLavaJato();
        else AreaAdmin();

    }

    public void telaCadastroLavaJato() {
        this.getContentPane().removeAll();
        // Jframe e Jpanel variáveis
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

    private void SetFuncionamento() {
        this.getContentPane().removeAll();
        setTitle("Selecione os dias de funcionamento");
        setSize(preferredSize);

        JPanel MainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints MainC = new GridBagConstraints();
        MainC.fill = GridBagConstraints.HORIZONTAL;
        MainC.insets = new Insets(5, 10, 5, 10);

        JPanel diasPanel = new JPanel(new GridBagLayout());
        diasPanel.setBorder(BorderFactory.createTitledBorder("Dias de funcionamento"));
        diasPanel.setPreferredSize(new Dimension(400, 250));
        GridBagConstraints DiasC = new GridBagConstraints();
        DiasC.fill = GridBagConstraints.HORIZONTAL;
        DiasC.insets = new Insets(5, 10, 5, 10);

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
            DiasC.gridx = 0;
            DiasC.gridy = i;
            diasPanel.add(check, DiasC);
        }

        MainC.gridx = 0;
        MainC.gridy = 0;
        MainPanel.add(diasPanel, MainC);


        JPanel btnPanel = new JPanel(new GridBagLayout());
        GridBagConstraints btnC = new GridBagConstraints();
        btnC.fill = GridBagConstraints.HORIZONTAL;
        btnC.insets = new Insets(5, 10, 5, 10);

        JButton submit = new JButton("Continuar");
        submit.addActionListener(e -> {
            this.place.setDiasAbertos(dias);
            setHorarioFuncionamento();
        });

        btnC.gridx = 0;
        btnC.gridy = 0;
        btnPanel.add(submit, btnC);

        MainC.gridx = 0;
        MainC.gridy = 1;
        MainPanel.add(btnPanel, MainC);

        this.getContentPane().add(MainPanel);
        this.pack();
    }

    public void AreaAdmin() {
        this.getContentPane().removeAll();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Code Wash");
        setSize(200, 100);
        setLayout(new GridLayout(1, 1));
        setLocationRelativeTo(null);

        // horarios
        JButton horarios = new JButton("Horários");
        horarios.addActionListener(e -> ListaHorarios());
        // editar produtos
        JButton produtos = new JButton("Editar produtos");
        produtos.addActionListener(e -> EditaProdutos());
        //Voltar para a tela de login
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            this.dispose();
            this.setEnabled(false);
            login.setEnabled(true);
            login.display();
        });

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Bem vindo de volta, " + user.getNome() + "!"));
        panel.setPreferredSize(new Dimension(250, 150));
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

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(btnVoltar, constraints);

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

        panel.add(Spinners(), constraints);

        JButton submit = new JButton("Continuar");
        submit.addActionListener(e -> {
            try {
                this.place.setFuncionamento(horarios.get(0), horarios.get(1), horarios.get(2));
                AreaAdmin();
            } catch (HorarioException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(submit, constraints);

        this.getContentPane().add(panel);
        this.pack();
    }

    private JPanel Spinners() {
        JPanel horarios = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsHorarios = new GridBagConstraints();
        constraintsHorarios.fill = GridBagConstraints.HORIZONTAL;
        constraintsHorarios.insets = new Insets(5, 10, 5, 10);

        JLabel lblAbertura = new JLabel("Horário de Abertura");
        JLabel lblIntervalo = new JLabel("Horário de Intervalo");
        JLabel lblFechamento = new JLabel("Horário de Fechamento");

        JSpinner spnAbertura = new JSpinner(new SpinnerNumberModel(8, 0, 21, 1));
        this.horarios.add((int) spnAbertura.getValue());
        JSpinner spnIntervalo = new JSpinner(new SpinnerNumberModel(12, 1, 22, 1));
        this.horarios.add((int) spnIntervalo.getValue());
        JSpinner spnFechamento = new JSpinner(new SpinnerNumberModel(18, 2, 23, 1));
        this.horarios.add((int) spnFechamento.getValue());

        JSpinner.NumberEditor deAbertura = new JSpinner.NumberEditor(spnAbertura, "00");
        JSpinner.NumberEditor deIntervalo = new JSpinner.NumberEditor(spnIntervalo, "00");
        JSpinner.NumberEditor deFechamento = new JSpinner.NumberEditor(spnFechamento, "00");

        spnAbertura.setEditor(deAbertura);
        spnAbertura.addChangeListener(e -> {
            if ((int) spnAbertura.getValue() >= (int) spnIntervalo.getValue()) {
                spnIntervalo.setValue((int) spnAbertura.getValue() + 1);
            }
            if ((int) spnAbertura.getValue() >= (int) spnFechamento.getValue()) {
                spnFechamento.setValue((int) spnAbertura.getValue() + 1);
            }
            this.horarios.set(0, (int) spnAbertura.getValue());
        });
        spnIntervalo.setEditor(deIntervalo);
        spnIntervalo.addChangeListener(e -> {
            if ((int) spnIntervalo.getValue() <= (int) spnAbertura.getValue()) {
                spnAbertura.setValue((int) spnIntervalo.getValue() - 1);
            }
            if ((int) spnIntervalo.getValue() >= (int) spnFechamento.getValue()) {
                spnFechamento.setValue((int) spnIntervalo.getValue() + 1);
            }
            this.horarios.set(1, (int) spnIntervalo.getValue());
        });
        spnFechamento.setEditor(deFechamento);
        spnFechamento.addChangeListener(e -> {
            if ((int) spnFechamento.getValue() <= (int) spnIntervalo.getValue()) {
                spnIntervalo.setValue((int) spnFechamento.getValue() - 1);
            }
            if ((int) spnFechamento.getValue() <= (int) spnAbertura.getValue()) {
                spnAbertura.setValue((int) spnFechamento.getValue() - 1);
            }
            this.horarios.set(2, (int) spnFechamento.getValue());
        });

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
        this.getContentPane().removeAll();
        setTitle("Horários Marcados");

        JPanel Mainpanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        JPanel lblHorarios = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsHorarios = new GridBagConstraints();
        constraintsHorarios.fill = GridBagConstraints.HORIZONTAL;
        constraintsHorarios.insets = new Insets(5, 10, 5, 10);

        JLabel lblHorario = new JLabel("Horário");
        constraintsHorarios.gridx = 0;
        constraintsHorarios.gridy = 0;
        lblHorarios.add(lblHorario, constraintsHorarios);

        for (int i = place.getAbertura(); i < place.getFechamento(); i++) {
            lblHorario = new JLabel(i >= 10 ? i + ":00" : "0" + i + ":00");
            constraintsHorarios.gridx = 0;
            constraintsHorarios.gridy = i - place.getAbertura() + 1;
            constraintsHorarios.weighty = 2;
            lblHorarios.add(lblHorario, constraintsHorarios);
        }

        JPanel lblDias = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsDias = new GridBagConstraints();
        constraintsDias.fill = GridBagConstraints.HORIZONTAL;
        constraintsDias.insets = new Insets(5, 10, 5, 10);

        for (Dias dia : this.place.getDiasAbertos()) {
            JLabel lblDia = new JLabel(dia.toString());
            constraintsDias.gridx = dia.ordinal();
            constraintsDias.gridy = 0;
            lblDias.add(lblDia, constraintsDias);

            for (int i = place.getAbertura(); i < place.getFechamento(); i++) {
                if (i == place.getIntervalo()) {
                    JLabel lblIntervalo = new JLabel("Intervalo");
                    constraintsDias.gridx = dia.ordinal();
                    constraintsDias.gridy = i - place.getAbertura() + 1;
                    constraintsDias.weighty = 2;
                    constraintsDias.weightx = 6;
                    lblDias.add(lblIntervalo, constraintsDias);
                    continue;
                }
                if (this.place.getCont(dia, i) != 0) {
                    final int hora = i;
                    JButton reservado = new JButton("agendado");
//                    reservado.setFont(new Font("Arial", Font.PLAIN, 10));
                    reservado.addActionListener(e -> AgendaManager(dia, hora));
                    reservado.setBackground(new Color(0, 0, 0, 0));
                    reservado.setBorder(null);
                    reservado.setForeground(Color.BLACK);
                    constraintsDias.gridx = dia.ordinal();
                    constraintsDias.gridy = i - place.getAbertura() + 1;
                    constraintsDias.weighty = 2;
                    constraintsDias.weightx = 6;
                    lblDias.add(reservado, constraintsDias);
                } else {
                    JLabel lblVazio = new JLabel("Vazio");
                    constraintsDias.gridx = dia.ordinal();
                    constraintsDias.gridy = i - place.getAbertura() + 1;
                    constraintsDias.weighty = 2;
                    constraintsDias.weightx = 6;
                    lblDias.add(lblVazio, constraintsDias);
                }
            }
        }

        constraints.gridx = 0;
        constraints.gridy = 0;
        Mainpanel.add(lblHorarios, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        Mainpanel.add(lblDias, constraints);

        JPanel btnPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsBtn = new GridBagConstraints();
        constraintsBtn.fill = GridBagConstraints.HORIZONTAL;
        constraintsBtn.insets = new Insets(5, 10, 5, 10);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            this.getContentPane().removeAll();
            this.AreaAdmin();
        });

        constraintsBtn.gridx = 0;
        constraintsBtn.gridy = 0;
        btnPanel.add(btnVoltar, constraintsBtn);

        constraints.gridx = 0;
        constraints.gridy = 1;
        Mainpanel.add(btnPanel, constraints);

        this.getContentPane().add(Mainpanel);
        this.pack();

        this.setLocationRelativeTo(null);

    }

    private void AgendaManager(Dias dia, int hora) {
        this.getContentPane().removeAll();
        setTitle("Reservas");

        List<String> clientesToRemove = new ArrayList<>();

        JPanel Mainpanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        JLabel Title = new JLabel("Horário: " + dia.toString() + " " + hora + ":00");
        constraints.gridx = 0;
        constraints.gridy = 0;
        Mainpanel.add(Title, constraints);

        JLabel subTitle = new JLabel("Marcado por: ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        Mainpanel.add(subTitle, constraints);

        JPanel lblClientes = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsClientes = new GridBagConstraints();
        constraintsClientes.fill = GridBagConstraints.HORIZONTAL;
        constraintsClientes.insets = new Insets(5, 10, 5, 10);

        for (String cliente : this.place.getClientes(dia, hora)) {
            JCheckBox lblCliente = new JCheckBox(cliente);
            lblCliente.addActionListener(e -> {
                if (lblCliente.isSelected()) {
                    clientesToRemove.add(cliente);
                } else {
                    clientesToRemove.remove(cliente);
                }
            });
            constraintsClientes.gridx = 0;
            constraintsClientes.gridy = this.place.getClientes(dia, hora).indexOf(cliente);
            lblClientes.add(lblCliente, constraintsClientes);
        }

        constraints.gridx = 0;
        constraints.gridy = 2;
        Mainpanel.add(lblClientes, constraints);

        JPanel btnPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsBtn = new GridBagConstraints();
        constraintsBtn.fill = GridBagConstraints.HORIZONTAL;
        constraintsBtn.insets = new Insets(5, 10, 5, 10);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> ListaHorarios());
        constraintsBtn.gridx = 0;
        constraintsBtn.gridy = 0;
        btnPanel.add(btnVoltar, constraintsBtn);

        JButton btnRemover = new JButton("Entregar Carro(s)");
        btnRemover.addActionListener(e -> {
            this.place.removeCliente(clientesToRemove);
            AgendaManager(dia, hora);
        });
        constraintsBtn.gridx = 1;
        constraintsBtn.gridy = 0;
        btnPanel.add(btnRemover, constraintsBtn);

        constraints.gridx = 0;
        constraints.gridy = 3;
        Mainpanel.add(btnPanel, constraints);

        this.getContentPane().add(Mainpanel);
        this.pack();
    }

    private void EditaProdutos() {
        this.setLayout(new GridLayout(0, 2, 0, 0));
        this.getContentPane().removeAll();

        desenhaLista();
        desenhaFormulario();

        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void desenhaFormulario() {
        JPanel MainPanel = new JPanel();
        MainPanel.setBorder(BorderFactory.createTitledBorder("Edição de Produtos"));

        JPanel formulario = new JPanel();
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, 5, 10));
        painelLabel.add(new JLabel("Nome"));
        painelLabel.add(new JLabel("Preço"));
        painelLabel.add(new JLabel("Quantidade"));

        JPanel painelField = new JPanel();
        painelField.setLayout(new GridLayout(0, 1, 5, 10));
        JNome = new JTextField(20);
        JPreco = new JTextField(20);
        JQuantidade = new JTextField(20);

        painelField.add(JNome);
        painelField.add(JPreco);
        painelField.add(JQuantidade);

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
        int quantidade = Integer.parseInt(JQuantidade.getText());
        this.place.addProduto(nome, preco, quantidade);
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
        SetFuncionamento();
    }

    @Override
    public List<Place> listPlaces(List<Place> places) {
        // Função que lista os lava jatos associados ao usuário
        places.removeIf(place -> place.getEmail().equals(user.getEmail()));// Remove o Lava jato do usuário da lista
        // para atualizar
        places.add(this.place); // Adiciona o lava jato do usuário na lista
        return places; // Retorna a lista
    }

}
