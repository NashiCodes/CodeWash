// NOME: Gabriel de Oliveira Vieira                         MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                           MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                      MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                  MATRÍCULA: 202165193AC

package CodeWash.model;

public enum Dias {
    SEGUNDA(0), TERCA(1), QUARTA(2), QUINTA(3), SEXTA(4), SABADO(5), DOMINGO(6);

    private final int index;

    Dias(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

