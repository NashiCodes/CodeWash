// NOME: Gabriel de Oliveira Vieira                       MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                         MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                    MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC
package CodeWash.persistence;

import java.util.List;

public interface Persistence<T> {

    String DIRECTORY = "data";
    void save(List<T> itens);

    List<T> findAll();
}
