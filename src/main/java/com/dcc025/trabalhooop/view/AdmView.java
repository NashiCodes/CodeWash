package com.dcc025.trabalhooop.view;

import com.dcc025.trabalhooop.model.Usuario;

import javax.swing.*;

//Classe que representa a tela do administrador e seus métodos
public class AdmView extends JFrame {
    private final Usuario user;

    public AdmView(Usuario user) {
        this.user = user;
    }
}
