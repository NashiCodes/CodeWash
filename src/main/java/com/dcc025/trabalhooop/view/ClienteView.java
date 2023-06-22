package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.controller.User.Select;
import com.dcc025.trabalhooop.controller.User.UserManager;
import com.dcc025.trabalhooop.model.Place;
import com.dcc025.trabalhooop.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//Classe que representa a tela do cliente e seus métodos
public class ClienteView extends UserView {
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); //Pega o tamanho da tela
    private final Dimension preferredSize = new Dimension(450, 400); //Define o tamanho preferido da tela
    private final int x = (int) ((dimension.getWidth() - this.getWidth()) / 2); //Define a posição x da tela
    private final int y = (int) ((dimension.getHeight() - this.getHeight()) / 2); //Define a posição y da tela
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
        //TODO: Implementar a lista de lava jatos
        //Deve conter uma lista clicavel de lava jatos
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Bem vindo, " + user.getNome() + "!");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        JButton button = new JButton("Sair");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            this.dispose();
            new TelaInicial().display();
        });
        panel.add(button);

        this.add(panel);
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
    }
}
