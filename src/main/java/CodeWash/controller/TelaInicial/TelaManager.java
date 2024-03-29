// NOME: Gabriel de Oliveira Vieira                         MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                           MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                      MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                  MATRÍCULA: 202165193AC

package CodeWash.controller.TelaInicial;

import CodeWash.model.Usuario;
import CodeWash.persistence.Persistence;
import CodeWash.persistence.UserPersistence;
import CodeWash.view.TelaInicial;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class TelaManager implements WindowListener {

    private final TelaInicial tela;

    public TelaManager(TelaInicial tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Usuario> usuarioPersistence = new UserPersistence();
        List<Usuario> usuarios = usuarioPersistence.findAll();
        tela.carregaUsuarios(usuarios);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Usuario> usuarioPersistence = new UserPersistence();
        usuarioPersistence.save(tela.getUsuarios());
    }

    @Override
    public void windowClosed(WindowEvent e) {
        Persistence<Usuario> usuarioPersistence = new UserPersistence();
        usuarioPersistence.save(tela.getUsuarios());
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
        Persistence<Usuario> usuarioPersistence = new UserPersistence();
        usuarioPersistence.save(tela.getUsuarios());
    }
}
