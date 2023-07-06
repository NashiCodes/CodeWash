// NOME: Gabriel de Oliveira Vieira                       MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                         MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                    MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

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
    public void itemSelected(){}
}
