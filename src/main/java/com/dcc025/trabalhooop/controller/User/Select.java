package com.dcc025.trabalhooop.controller.User;

import com.dcc025.trabalhooop.view.UserView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Select implements ListSelectionListener {
    private final UserView tela;

    public Select(UserView tela) {
        this.tela = tela;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.itemSelected();
    }
}
