package br.com.mangarosa.collections;

public class ListaEncadeada<T> {

    private No<T> cabeca;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void append(T value) {
        No<T> novoNo = new No<>(value);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No<T> atual = cabeca;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novoNo);
        }
        tamanho++;
    }

    public T get(int position) {
        if (position < 0 || position >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + position);
        }

        No<T> atual = cabeca;
        for (int i = 0; i < position; i++) {
            atual = atual.getProx();
        }
        return atual.getValor();
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    // Método que verifica se a lista contém um elemento
    public boolean contains(T value) {
        No<T> atual = cabeca;
        while (atual != null) {
            if (atual.getValor().equals(value)) {
                return true;
            }
            atual = atual.getProx();
        }
        return false; // Retorna false se o valor não for encontrado
    }

    public void insertAt(int position, T value) {
        if (position < 0 || position > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + position);
        }

        No<T> novoNo = new No<>(value);
        if (position == 0) {
            novoNo.setProx(cabeca);
            cabeca = novoNo;
        } else {
            No<T> atual = cabeca;
            for (int i = 0; i < position - 1; i++) {
                atual = atual.getProx();
            }
            novoNo.setProx(atual.getProx());
            atual.setProx(novoNo);
        }
        tamanho++;
    }

    public void addAll(ListaEncadeada<T> list) {
        No<T> atual = list.cabeca;
        while (atual != null) {
            append(atual.getValor());
            atual = atual.getProx();
        }
    }

    public boolean remove(int position) {
        if (position < 0 || position >= tamanho) {
            return false;
        }

        if (position == 0) {
            cabeca = cabeca.getProx();
        } else {
            No<T> atual = cabeca;
            for (int i = 0; i < position - 1; i++) {
                atual = atual.getProx();
            }
            atual.setProx(atual.getProx().getProx());
        }
        tamanho--;
        return true;
    }

    public boolean clear() {
        cabeca = null;
        tamanho = 0;
        return true;
    }

    public int indexOf(T value) {
        No<T> atual = cabeca;
        for (int i = 0; i < tamanho; i++) {
            if (atual.getValor().equals(value)) {
                return i;
            }
            atual = atual.getProx();
        }
        return -1; // Retorna -1 se o valor não for encontrado
    }

    public void insert(T musica, int novaPosicao) {
        if (novaPosicao < 0 || novaPosicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + novaPosicao);
        }

        No<T> novoNo = new No<>(musica);
        if (novaPosicao == 0) {
            novoNo.setProx(cabeca);
            cabeca = novoNo;
        } else {
            No<T> atual = cabeca;
            for (int i = 0; i < novaPosicao - 1; i++) {
                atual = atual.getProx();
            }
            novoNo.setProx(atual.getProx());
            atual.setProx(novoNo);
        }
        tamanho++;
    }
}
