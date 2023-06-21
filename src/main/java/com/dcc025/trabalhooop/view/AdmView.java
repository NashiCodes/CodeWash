package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.controller.User.UserManager;
import com.dcc025.trabalhooop.model.Place;
import com.dcc025.trabalhooop.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//Classe que representa a tela do administrador e seus métodos
public class AdmView extends UserView {
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension preferredSize = new Dimension(450, 400);
    private final int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
    private final int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
    private JTextField nome;
    private final Usuario user;

    private Place place;

    public AdmView(Usuario user) {
        super("Administrador");
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

    @Override
    public void carregaPlaces(List<Place> places) {
        for (Place place : places) {
            if (place.getName().equals(user.getEmail())) {
                this.place = place;
                break;
            }
        }
    }

    public List<Place> telaCadastro(List<Place> places) {
        return places;
    }

    public List<Place> CadastraLavaJato(List<Place> places) {
        places.add(new Place(nome.getText(), "Lava Jato"));
        return places;
    }

    public Place getPlace() {
        return place;
    }

    public List<Place> getPlaces() {
        return null;
    }
}
