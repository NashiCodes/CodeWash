package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.model.Usuario;

import javax.swing.*;

//Classe que representa a tela do cliente e seus métodos
public class ClienteView extends JFrame {
    private final Usuario user;

    public ClienteView(Usuario user) {
        this.user = user;
    }
}
