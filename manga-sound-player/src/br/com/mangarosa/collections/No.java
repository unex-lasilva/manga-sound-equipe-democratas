package br.com.mangarosa.collections;

public class No<T> {
    private T valor;
    private No<T> prox;

    public No() {
        this.valor = null;
        this.prox = null;
    }

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProx() {
        return prox;
    }

    public void setProx(No<T> prox) {
        this.prox = prox;
    }
}
