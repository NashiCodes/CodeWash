package CodeWash.view;

import CodeWash.controller.User.Select;
import CodeWash.controller.User.UserManager;
import CodeWash.exception.HorarioException;
import CodeWash.model.Dias;
import CodeWash.model.Place;
import CodeWash.model.Produto;
import CodeWash.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//Classe que representa a tela do cliente e seus métodos
public class ClienteView extends UserView {
    private final Dimension preferredSize = new Dimension(300, 250); //Define o tamanho preferido da tela
    private final Usuario user; //Usuário atual
    private final JList<Place> LavaJatos; //Lista de lava jatos

    public ClienteView(Usuario user) {
        //Função que cria a tela do cliente
        super("Cliente");   //Chama o construtor da classe pai
        this.user = user;  //Salva o usuário atual

        DefaultListModel<Place> model = new DefaultListModel<>();
        this.LavaJatos = new JList<>(model);

        this.setSize(preferredSize); //Define o tamanho da tela
        this.addWindowListener(new UserManager(this)); //Adiciona um listener para o comportamento da tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Define o que acontece quando a tela é fechada
        //Define a posição x da tela
        //Pega o tamanho da tela
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        //Define a posição y da tela
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y); //Define a posição da tela
        this.setEnabled(true); //Define se a tela está habilitada
        this.setVisible(true); //Define se a tela está visível
    }

    @Override
    public void display() {
        this.getContentPane().removeAll(); //Remove todos os componentes da tela
        mainWindow();
        this.pack();
    }

    private void mainWindow() {
        //Atualmente apenas mostra o nome do usuário e um botão para sair
        //Implementar a lista de lava jatos
        //Deve conter uma lista clicavel de lava jatos
        JPanel panel = new JPanel(); //Cria um painel
        panel.setLayout(new BorderLayout()); //Define o layout do painel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Define a borda do painel
        panel.setPreferredSize(preferredSize);

        LavaJatos.addListSelectionListener(new Select(this)); //Adiciona um listener para a lista

        panel.add(new JScrollPane(LavaJatos), BorderLayout.CENTER); //Adiciona a lista ao painel

        getContentPane().add(panel); //Adiciona o painel à tela
        pack();
    }

    @Override
    public void carregaPlaces(List<Place> places) {
        //Função que carrega a lista de lava jatos
        DefaultListModel<Place> model = (DefaultListModel<Place>) LavaJatos.getModel(); //Pega o modelo da lista
        model.clear(); //Remove todos os lava jatos do modelo
        for (Place place : places) { //Para cada lava jato na lista
            model.addElement(place); //Adiciona o lava jato ao modelo
        }
    }

    @Override
    public List<Place> listPlaces(List<Place> places) { //Função que retorna a lista de lava jatos
        DefaultListModel<Place> model = (DefaultListModel<Place>) LavaJatos.getModel(); //Pega o modelo da lista
        places.clear(); //Remove todos os lava jatos da lista
        for (int i = 0; i < model.getSize(); i++) { //Para cada lava jato no modelo
            places.add(model.get(i)); //Adiciona o lava jato na lista
        }
        return places; //Retorna a lista
    }

    @Override
    public void itemSelected() {
        //Função que é chamada quando um item da lista é selecionado
        int index = LavaJatos.getSelectedIndex(); //Pega o índice do item selecionado
        if (index != -1) { //Se o índice for válido
            Place place = LavaJatos.getModel().getElementAt(index); //Pega o lava jato selecionado
            compose(place);
        }
    }

    private void compose(Place place) {
        this.getContentPane().removeAll();

        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        JPanel conteudo = new JPanel();
        conteudo.setLayout(new GridBagLayout());
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.HORIZONTAL;
        constraints2.insets = new Insets(5, 10, 5, 10);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridBagLayout());

        JLabel nome = new JLabel(place.getName());
        nome.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(Box.createVerticalGlue()); // Add glue to vertically center the label
        labelPanel.add(nome);
        labelPanel.add(Box.createVerticalGlue()); // Add glue to vertically center the label

        constraints2.gridx = 0;
        constraints2.gridy = 0;
        constraints2.gridwidth = 2;
        conteudo.add(labelPanel, constraints2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton Comprar = new JButton("Comprar Produtos");
        Comprar.addActionListener(e -> comprar(place));
        buttonPanel.add(Comprar);

        JButton Agendar = new JButton("Agendar");
        Agendar.addActionListener(e -> agendar(place));
        buttonPanel.add(Agendar);

        JButton Voltar = new JButton("Voltar");
        Voltar.addActionListener(e -> display());
        buttonPanel.add(Voltar);

        constraints2.gridx = 0;
        constraints2.gridy = 1;
        constraints2.gridwidth = 2;
        conteudo.add(buttonPanel, constraints2);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        MainPanel.add(conteudo, constraints);

        this.getContentPane().add(MainPanel);
        pack();
    }

    private void agendar(Place place) {
        //Implementar a tela de agendamento
        //Deve conter opções de data e horário, ou calendario, ou algo do tipo
        //botão pra voltar
        //botão pra agendar
        this.getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setPreferredSize(preferredSize);

        JPanel conteudo = new JPanel();
        conteudo.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel titulo = new JLabel("Selecione o dia e horário que deseja agendar");
        panel.add(titulo, BorderLayout.NORTH);

        JLabel selecioneDia = new JLabel("Selecione o dia");
        conteudo.add(selecioneDia, BorderLayout.WEST);

        final Dias[] diaSelecionado = new Dias[1];
        JComboBox<Dias> diasComboBox = new JComboBox<>();
        for (Dias dia : place.getDiasAbertos()) {
            diasComboBox.addItem(dia);
        }
        diasComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                diaSelecionado[0] = (Dias) e.getItem();
            }
        });
        conteudo.add(diasComboBox, BorderLayout.CENTER);

        JLabel selecioneHora = new JLabel("Selecione a hora");
        conteudo.add(selecioneHora, BorderLayout.WEST);

        JComboBox<String> horasComboBox = new JComboBox<>();
        for (int i = place.getAbertura(); i < place.getFechamento(); i++) {
            if (place.verifica(diaSelecionado[0], i)) horasComboBox.addItem(Integer.toString(i));
        }
        conteudo.add(horasComboBox, BorderLayout.CENTER);

        JButton Agendar = new JButton("Agendar");
        Agendar.addActionListener(e -> {
            try {
                place.marcarHorario(user.getEmail(), diaSelecionado[0], (String) horasComboBox.getSelectedItem());
            } catch (HorarioException horarioException) {
                JOptionPane.showMessageDialog(null, "Horário inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(horasComboBox, BorderLayout.SOUTH);

        JButton Voltar = new JButton("Voltar");
        Voltar.addActionListener(e -> compose(place));
        conteudo.add(Voltar, BorderLayout.SOUTH);

        panel.add(conteudo, BorderLayout.CENTER);
        this.getContentPane().add(panel);
        this.pack();
    }

    private void comprar(Place place) {
        this.getContentPane().removeAll();

        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);

        JLabel titulo = new JLabel("Selecione os produtos que deseja comprar");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        MainPanel.add(titulo, constraints);

        JPanel conteudo = new JPanel();
        conteudo.setLayout(new GridBagLayout());
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.HORIZONTAL;
        constraints2.insets = new Insets(5, 10, 5, 10);


        JPanel produtosPanel = new JPanel();
        produtosPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.fill = GridBagConstraints.HORIZONTAL;
        constraints3.insets = new Insets(5, 10, 5, 10);

        JLabel selecioneProduto = new JLabel("Selecione o produto");
        constraints3.gridx = 0;
        constraints3.gridy = 0;
        produtosPanel.add(selecioneProduto, constraints3);

        HashMap<Produto, Integer> produtos = new HashMap<>();
        for (int i = 0; i < place.getProdutos().size(); i++) {
            Produto produto = place.getProdutos().get(i);
            JCheckBox produtoCheckBox = new JCheckBox(produto.getNome());
            JSpinner quantidade = new JSpinner(new SpinnerNumberModel(0, 0, produto.getQuantidade(), 1));
            JSpinner.NumberEditor editor = new JSpinner.NumberEditor(quantidade, "#");
            quantidade.setEditor(editor);

            produtoCheckBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    produtos.put(produto, (Integer) quantidade.getValue());
                } else {
                    produtos.remove(produto);
                }
            });
            quantidade.addChangeListener(e -> {
                if (produtoCheckBox.isSelected()) {
                    produtos.put(produto, (Integer) quantidade.getValue());
                }
            });

            constraints3.gridx = 0;
            constraints3.gridy = i + 1;
            produtosPanel.add(produtoCheckBox, constraints3);
            constraints3.gridx = 1;
            produtosPanel.add(quantidade, constraints3);
        }

        constraints2.gridx = 0;
        constraints2.gridy = 0;
        conteudo.add(produtosPanel, constraints2);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.fill = GridBagConstraints.HORIZONTAL;
        constraints4.insets = new Insets(5, 10, 5, 10);

        JButton EfetuarCompra = new JButton("Finalizar Compra");
        EfetuarCompra.addActionListener(e -> efetuarCompra(place, produtos));
        constraints4.gridx = 0;
        constraints4.gridy = 0;
        botoesPanel.add(EfetuarCompra, constraints4);

        JButton Voltar = new JButton("Voltar");
        Voltar.addActionListener(e -> compose(place));
        constraints4.gridx = 1;
        botoesPanel.add(Voltar, constraints4);

        constraints2.gridx = 0;
        constraints2.gridy = 1;
        conteudo.add(botoesPanel, constraints2);

        constraints.gridx = 0;
        constraints.gridy = 1;
        MainPanel.add(conteudo, constraints);

        this.getContentPane().add(MainPanel);
        this.pack();
        //Implementar a tela de compra
        //Deve conter uma lista de produtos, com a quantidade de cada produto
        //botão pra voltar
        //botão pra efetuar a compra
    }

    private void efetuarCompra(Place place, HashMap<Produto, Integer> produtos) {
        this.getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setPreferredSize(preferredSize);

        JPanel conteudo = new JPanel();
        conteudo.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel titulo = new JLabel("Dados da compra");
        conteudo.add(titulo, BorderLayout.NORTH);

        JTextArea dadosCompra = new JTextArea();
        dadosCompra.setEditable(false);
        dadosCompra.setText("Lava Jato: " + place.getName() + "\n" + "Produto: " + produtosComboBox.getSelectedItem() + "\n" + "Quantidade: " + quantidadeProd.getValue() + "\n" + "Valor Final: " + place.getProdutos().get(produtosComboBox.getSelectedIndex()).getPreco() * (int) quantidadeProd.getValue());
        conteudo.add(dadosCompra, BorderLayout.CENTER);

        JButton Cancelar = new JButton("Cancelar");
        Cancelar.addActionListener(e -> comprar(place));
        conteudo.add(Cancelar, BorderLayout.SOUTH);

        JButton Finalizar = new JButton("Finalizar");
        Finalizar.addActionListener(e -> JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!\n"));
        conteudo.add(Finalizar, BorderLayout.SOUTH);

        panel.add(conteudo, BorderLayout.CENTER);
        this.getContentPane().add(panel);
        this.pack();
    }
}
