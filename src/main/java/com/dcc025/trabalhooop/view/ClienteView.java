package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.controller.User.UserManager;
import com.dcc025.trabalhooop.model.Place;
import com.dcc025.trabalhooop.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//Classe que representa a tela do cliente e seus métodos
public class ClienteView extends UserView {
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension preferredSize = new Dimension(450, 400);
    private final int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
    private final int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
    private final Usuario user;
    private List<Place> places;

    public ClienteView(Usuario user) {
        super("Cliente");
        this.user = user;
    }

    @Override
    public void display() {
        this.setSize(preferredSize);
        this.addWindowListener(new UserManager(this));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(x, y);
        this.setVisible(true);



        this.pack();
    }

    private void mainWindow(){
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
    }

    @Override
    public Place getPlace() {
        return null;
    }

    @Override
    public List<Place> getPlaces() {
        return places;
    }
}
