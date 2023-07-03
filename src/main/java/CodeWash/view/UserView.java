package CodeWash.view;

import CodeWash.model.Place;

import javax.swing.*;
import java.util.List;

public abstract class UserView extends JFrame {

    public UserView(String title) {
        super(title);
    }

    public abstract void display();

    public abstract void carregaPlaces(List<Place> places);

    public abstract List<Place> listPlaces(List<Place> places);
    public abstract void itemSelected();
}
