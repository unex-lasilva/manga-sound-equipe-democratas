package br.com.mangarosa.collections;

public class No<T> {
    private T valor;
    private No<T> prox;

    // Construtor padrão
    public No() {
        this.valor = null;
        this.prox = null;
    }

    // Construtor com valor inicial
    public No(T valor) {
        this.valor = valor;
        this.prox = null;
    }

    // Retorna o valor armazenado no nó
    public T getValor() {
        return valor;
    }

    // Define um novo valor para o nó
    public void setValor(T valor) {
        this.valor = valor;
    }

    // Retorna o próximo nó
    public No<T> getProx() {
        return prox;
    }

    // Define o próximo nó
    public void setProx(No<T> prox) {
        this.prox = prox;
    }
}
