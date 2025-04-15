package main.java.br.com.mangarosa;

public class No {

    private Musica valor;
    private No prox;

    //constructor

    public No(Musica valor){
        this.valor = valor;
        this.prox = null;
    }

    public Musica getValor() {
        return this.valor;
    }

    public void setValor(Musica valor) {
        this.valor = valor;
    }

    public No getProx() {
        return this.prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}

