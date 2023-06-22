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
    private JTextField JNome;
    private final Usuario user;
    private Place place;

    public AdmView(Usuario user) {
        //Função que cria a tela do administrador
        super("Administrador"); //Título da tela
        this.user = user;    //Usuário que está logado
        this.setSize(preferredSize);    //Tamanho da tela
        this.addWindowListener(new UserManager(this));  //Adiciona um listener para o botão de fechar a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Fecha a aplicação quando a tela é fechada
        this.setLocation(x, y); //Posição da tela
        this.setVisible(true);  //Torna a tela visível
        this.setEnabled(true);  //Torna a tela habilitada
    }

    @Override
    public void display() {
        telaInicial();
        this.pack();
    }

    @Override
    public void carregaPlaces(List<Place> places) {
        //Função que carrega os lava jatos associados ao usuário
        for (Place place : places) {   //Percorre a lista de lava jatos
            if (place.getEmail().equals(user.getEmail())) {   //Verifica se o email do usuário é igual ao email do lava jato
                this.place = place; //Se sim, o lava jato é carregado
                break; //Para o loop
            }
        }
    }

    public void telaInicial() {
        //TODO: Implementar tela de cadastro dos lava jatos
        //verifica se o usuário já tem um Lava jato associado a ele
        //se sim, abre a tela de edição do lava jato, como os horários de funcionamento, edição de produtos e serviços, etc
        //se não, exibe um aviso de boas vindas e abre a tela de cadastro do lava jato
    }

    public void CadastraLavaJato() {
        place = new Place(JNome.getText(), user.getEmail());
    }

    @Override
    public List<Place> listPlaces(List<Place> places) {
        //Função que lista os lava jatos associados ao usuário
        places.removeIf(place -> place.getEmail().equals(user.getEmail()));//Remove o Lava jato do usuário da lista para atualizar
        places.add(this.place); //Adiciona o lava jato do usuário na lista
        return places; //Retorna a lista
    }

    @Override
    public void itemSelected() {
        //Função que é chamada quando um item é selecionado
    }
}
