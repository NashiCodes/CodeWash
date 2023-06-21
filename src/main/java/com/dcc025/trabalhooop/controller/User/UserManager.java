package com.dcc025.trabalhooop.controller.User;

import com.dcc025.trabalhooop.model.Place;
import com.dcc025.trabalhooop.persistence.*;
import com.dcc025.trabalhooop.view.AdmView;
import com.dcc025.trabalhooop.view.UserView;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class UserManager implements WindowListener {

    private final UserView tela;
    private List<Place> places;

    public UserManager(UserView tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Place> placePersistence = new PlacePersistence();
        this.places = placePersistence.findAll();
        tela.carregaPlaces(places);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (AdmView.class.equals(tela.getClass())) places.add(tela.getPlace());
        else places = tela.getPlaces();
        Persistence<Place> placePersistence = new PlacePersistence();
        placePersistence.save(places);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
