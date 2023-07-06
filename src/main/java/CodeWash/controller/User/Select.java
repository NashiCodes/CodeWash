// NOME: Gabriel de Oliveira Vieira                         MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                           MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                      MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                  MATRÍCULA: 202165193AC

package CodeWash.controller.User;

import CodeWash.view.UserView;

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
