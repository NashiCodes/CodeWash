package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.model.Place;

import javax.swing.*;
import java.util.List;

public abstract class UserView extends JFrame {

    public UserView(String title) {
        super(title);
    }

    public abstract void display();

    public abstract void carregaPlaces(List<Place> places);

    public abstract Place getPlace();
    public abstract List<Place> getPlaces();
}
