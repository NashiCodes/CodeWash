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
import java.util.List;


//Classe que representa a tela do cliente e seus métodos
public class ClienteView extends UserView {
    private final Dimension preferredSize = new Dimension(450, 400); //Define o tamanho preferido da tela
    private final Usuario user; //Usuário atual
    private final JList<Place> LavaJatos; //Lista de lava jatos

    public ClienteView(Usuario user) {
        //Função que cria a tela do cliente
        super("Cliente");   //Chama o construtor da classe pai
        this.user = user;  //Salva o usuário atual

        DefaultListModel<Place> listModel = new DefaultListModel<>(); //Cria um modelo de lista
        this.LavaJatos = new JList<>(listModel); //Cria uma lista com o modelo criado
        this.LavaJatos.addListSelectionListener(new Select(this)); //Adiciona um listener para a lista

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

        DefaultListModel<Place> model = new DefaultListModel<>(); //Cria um modelo de lista
        LavaJatos.setModel(model); //Define o modelo da lista
        LavaJatos.addListSelectionListener(new Select(this)); //Adiciona um listener para a lista

        panel.add(new JScrollPane(LavaJatos), BorderLayout.CENTER); //Adiciona a lista ao painel

        getContentPane().add(panel); //Adiciona o painel à tela
    }

    @Override
    public void carregaPlaces(List<Place> places) {
        //Função que carrega a lista de lava jatos
        DefaultListModel<Place> model = (DefaultListModel<Place>) LavaJatos.getModel(); //Pega o modelo da lista
        for (Place place : places) { //Para cada lava jato
            if (place != null) //Se o lava jato não for nulo
                model.addElement(place); //Adiciona o lava jato ao modelo
        }
        LavaJatos.setModel(model); //Define o modelo da lista
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
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setPreferredSize(preferredSize);

        JPanel conteudo = new JPanel();
        conteudo.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel nome = new JLabel(place.getName());
        conteudo.add(nome, BorderLayout.NORTH);
        JButton Comprar = new JButton("Comprar Produtos");
        Comprar.addActionListener(e -> comprar(place));
        conteudo.add(Comprar, BorderLayout.CENTER);

        JButton Agendar = new JButton("Agendar");
        Agendar.addActionListener(e -> agendar(place));
        conteudo.add(Agendar, BorderLayout.SOUTH);

        JButton Voltar = new JButton("Voltar");
        Voltar.addActionListener(e -> display());
        conteudo.add(Voltar, BorderLayout.SOUTH);

        panel.add(conteudo, BorderLayout.CENTER);
        this.getContentPane().add(panel);
        this.pack();
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
                diaSelecionado[0] = (Dias) e.getItem();}
        });
        conteudo.add(diasComboBox, BorderLayout.CENTER);

        JLabel selecioneHora = new JLabel("Selecione a hora");
        conteudo.add(selecioneHora, BorderLayout.WEST);

        JComboBox<String> horasComboBox = new JComboBox<>();
        for (int i = place.getAbertura(); i < place.getFechamento(); i++) {
            if(place.verifica(diaSelecionado[0], i))
                horasComboBox.addItem(Integer.toString(i));
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
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setPreferredSize(preferredSize);

        JPanel conteudo = new JPanel();
        conteudo.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel titulo = new JLabel("Selecione os produtos que deseja comprar");
        conteudo.add(titulo, BorderLayout.NORTH);

        JPanel produtoPanel = new JPanel();
        produtoPanel.setLayout(new GridLayout(1, 2, 10, 10));
        JComboBox<String> produtosComboBox = new JComboBox<>();
        List<Produto> produtos = place.getProdutos();
        for (Produto produto : produtos) {
            produtosComboBox.addItem(produto.getNome());
        }

        conteudo.add(produtosComboBox, BorderLayout.CENTER);
        
        JSpinner quantidadeProd = new JSpinner();
        conteudo.add(quantidadeProd, BorderLayout.CENTER);

        JButton EfetuarCompra = new JButton("Finalizar Compra");
        EfetuarCompra.addActionListener(e -> efetuarCompra(place, produtosComboBox, quantidadeProd));
        conteudo.add(EfetuarCompra, BorderLayout.SOUTH);

        JButton Voltar = new JButton("Voltar");
        Voltar.addActionListener(e -> compose(place));
        conteudo.add(Voltar, BorderLayout.SOUTH);

        panel.add(conteudo, BorderLayout.CENTER);
        this.getContentPane().add(panel);
        this.pack();
        //Implementar a tela de compra
        //Deve conter uma lista de produtos, com a quantidade de cada produto
        //botão pra voltar
        //botão pra efetuar a compra
        }

    private void efetuarCompra(Place place, JComboBox<String> produtosComboBox, JSpinner quantidadeProd) {
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
        dadosCompra.setText("Lava Jato: " + place.getName() + "\n" + 
                            "Produto: " + produtosComboBox.getSelectedItem() + "\n" +
                            "Quantidade: " + quantidadeProd.getValue() + "\n" +
                            "Valor Final: " + place.getProdutos().get(produtosComboBox.getSelectedIndex()).getPreco()
                            * (int) quantidadeProd.getValue());
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
