// NOME: Gabriel de Oliveira Vieira                       MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                         MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                    MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

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
import java.util.HashMap;
import java.util.List;


//Classe que representa a tela do cliente e seus métodos
public class ClienteView extends UserView {
    private final Dimension preferredSize = new Dimension(300, 250); //Define o tamanho preferido da tela
    private final Usuario user; //Usuário atual
    private final JList<Place> LavaJatos; //Lista de lava jatos
    private final TelaInicial login; //Tela de login

    public ClienteView(Usuario user, TelaInicial login) {
        //Função que cria a tela do cliente
        super("Bem Vindo, " + user.getNome());   //Chama o construtor da classe pai
        this.user = user;  //Salva o usuário atual
        this.login = login; //Salva a tela de login

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
        panel.setBorder(BorderFactory.createTitledBorder("Estes São os Lava Jatos Disponiveis: ")); //Define a borda do painel
        panel.setPreferredSize(preferredSize);

        LavaJatos.addListSelectionListener(new Select(this)); //Adiciona um listener para a lista

        panel.add(new JScrollPane(LavaJatos), BorderLayout.CENTER); //Adiciona a lista ao painel

        JPanel voltar = new JPanel(); //Cria um painel
        voltar.setLayout(new BorderLayout()); //Define o layout do painel

        JButton button = new JButton("Voltar"); //Cria um botão
        button.addActionListener(e -> { //Adiciona um listener para o botão
            this.dispose(); //Fecha a tela atual
            this.setEnabled(false); //Desabilita a tela atual
            login.setEnabled(true); //Habilita a tela de login
            login.display(); //Mostra a tela de login
        });
        voltar.add(button, BorderLayout.CENTER); //Adiciona o botão ao painel

        panel.add(voltar, BorderLayout.SOUTH); //Adiciona o painel ao painel principal

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
        this.setTitle("Lava Jato: " + place.getName());

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

        JLabel nome = new JLabel("Bem Vindo ao Lava Jato: " + place.getName());
        nome.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(Box.createVerticalGlue()); // Add glue to vertically center the label
        labelPanel.add(nome);
        labelPanel.add(Box.createVerticalGlue()); // Add glue to vertically center the label

        constraints2.gridx = 0;
        constraints2.gridy = 0;
        constraints2.gridwidth = 2;
        conteudo.add(labelPanel, constraints2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints btnConstraints = new GridBagConstraints();
        btnConstraints.fill = GridBagConstraints.HORIZONTAL;
        btnConstraints.insets = new Insets(5, 10, 5, 10);

        JButton Comprar = new JButton("Comprar Produtos");
        Comprar.addActionListener(e -> comprar(place));
        btnConstraints.gridx = 0;
        btnConstraints.gridy = 0;
        btnConstraints.gridwidth = 1;
        btnConstraints.weighty = 3;
        buttonPanel.add(Comprar, btnConstraints);

        JButton Agendar = new JButton("Agendar");
        Agendar.addActionListener(e -> agendar(place));
        btnConstraints.gridx = 0;
        btnConstraints.gridy = 1;
        buttonPanel.add(Agendar, btnConstraints);

        JButton Voltar = new JButton("Voltar");
        Voltar.addActionListener(e -> {
            this.setTitle("Lava Jatos");
            display();
        });
        btnConstraints.gridx = 0;
        btnConstraints.gridy = 2;
        buttonPanel.add(Voltar, btnConstraints);

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
        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new GridBagLayout());
        GridBagConstraints MainC = new GridBagConstraints();
        MainC.fill = GridBagConstraints.HORIZONTAL;
        MainC.insets = new Insets(5, 10, 5, 10);

        JLabel titulo = new JLabel("Selecione o dia e horário que deseja agendar");
        MainC.gridx = 0;
        MainC.gridy = 0;
        MainC.gridwidth = 2;
        MainPanel.add(titulo, MainC);

        JPanel conteudo = new JPanel();
        conteudo.setLayout(new GridBagLayout());
        GridBagConstraints contentC = new GridBagConstraints();
        contentC.fill = GridBagConstraints.HORIZONTAL;
        contentC.insets = new Insets(5, 10, 5, 10);

        JLabel selecioneDia = new JLabel("Selecione o dia");
        contentC.gridx = 0;
        contentC.gridy = 0;
        conteudo.add(selecioneDia, contentC);

        final Dias[] diaSelecionado = new Dias[1];
        JComboBox<Dias> diasComboBox = new JComboBox<>();
        JComboBox<String> horasComboBox = new JComboBox<>();
        for (Dias dia : place.getDiasAbertos()) {
            diasComboBox.addItem(dia);
        }
        diaSelecionado[0] = (Dias) diasComboBox.getSelectedItem();
        getHoras(place, diaSelecionado[0], horasComboBox);

        diasComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                diaSelecionado[0] = (Dias) e.getItem();
                horasComboBox.removeAllItems();
                getHoras(place, (Dias) e.getItem(), horasComboBox);
            }
        });
        contentC.gridx = 1;
        contentC.gridy = 0;
        conteudo.add(diasComboBox, contentC);

        JLabel selecioneHora = new JLabel("Selecione a hora");
        contentC.gridx = 0;
        contentC.gridy = 1;
        conteudo.add(selecioneHora, contentC);

        contentC.gridx = 1;
        contentC.gridy = 1;
        conteudo.add(horasComboBox, contentC);

        JButton Agendar = new JButton("Agendar");
        Agendar.addActionListener(e -> {
            try {
                place.marcarHorario(user.getEmail(), diaSelecionado[0], (String) horasComboBox.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Horário marcado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                compose(place);
            } catch (HorarioException horarioException) {
                JOptionPane.showMessageDialog(null, "Horário inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton Voltar = new JButton("Voltar");
        Voltar.addActionListener(e -> compose(place));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(Agendar);
        buttonPanel.add(Voltar);

        contentC.gridx = 0;
        contentC.gridy = 2;
        contentC.gridwidth = 2;
        conteudo.add(buttonPanel, contentC);

        MainC.gridx = 0;
        MainC.gridy = 1;
        MainC.gridwidth = 2;
        MainPanel.add(conteudo, MainC);

        this.getContentPane().add(MainPanel);
        this.pack();
    }

    private void getHoras(Place place, Dias dia, JComboBox<String> horasComboBox) {
        for (int i = place.getAbertura(); i < place.getFechamento(); i++) {
            if (place.verifica(dia, i))
                horasComboBox.addItem(i > 9 ? i + ":00" : "0" + i + ":00");
        }
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
    }

    private void efetuarCompra(Place place, HashMap<Produto, Integer> produtos) {
        this.getContentPane().removeAll();

        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new GridBagLayout());
        GridBagConstraints MainC = new GridBagConstraints();
        MainC.fill = GridBagConstraints.HORIZONTAL;
        MainC.insets = new Insets(5, 10, 5, 10);

        JLabel titulo = new JLabel("Dados da compra");
        MainC.gridx = 0;
        MainC.gridy = 0;
        MainPanel.add(titulo, MainC);

        JPanel conteudo = new JPanel();
        conteudo.setLayout(new GridBagLayout());
        GridBagConstraints contentC = new GridBagConstraints();
        contentC.fill = GridBagConstraints.HORIZONTAL;
        contentC.insets = new Insets(5, 10, 5, 10);

        JTextArea dados = new JTextArea();
        dados.setEditable(false);
        dados.setText("Produtos:\n");
        for (Produto produto : produtos.keySet()) {
            dados.append(produto.getNome() + "  -  " + produtos.get(produto) + " * " + produto.getPreco() + "\n");
        }
        dados.append("\nValor total: R$");
        double valorTotal = 0;
        for (Produto produto : produtos.keySet()) {
            valorTotal += produto.getPreco() * produtos.get(produto);
        }
        dados.append(String.valueOf(valorTotal));

        contentC.gridx = 0;
        contentC.gridy = 0;
        conteudo.add(dados, contentC);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridBagLayout());
        GridBagConstraints btnC = new GridBagConstraints();
        btnC.fill = GridBagConstraints.HORIZONTAL;
        btnC.insets = new Insets(5, 10, 5, 10);

        JButton Cancelar = new JButton("Cancelar");
        Cancelar.addActionListener(e -> comprar(place));
        btnC.gridx = 0;
        btnC.gridy = 0;
        botoesPanel.add(Cancelar, btnC);

        JButton Finalizar = new JButton("Finalizar");
        Finalizar.addActionListener(e -> {
            for (Produto produto : produtos.keySet()) {
                place.efetuarCompra(produto, produtos.get(produto));
            }
            JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
            compose(place);
        });
        btnC.gridx = 1;
        botoesPanel.add(Finalizar, btnC);

        contentC.gridx = 0;
        contentC.gridy = 1;
        conteudo.add(botoesPanel, contentC);

        MainC.gridx = 0;
        MainC.gridy = 1;
        MainPanel.add(conteudo, MainC);

        this.getContentPane().add(MainPanel);
        this.pack();
    }
}
