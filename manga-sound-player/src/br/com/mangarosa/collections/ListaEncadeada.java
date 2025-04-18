package br.com.mangarosa.collections;

/**
 * A classe {ListaEncadeada} implementa uma estrutura de dados de lista encadeada simples.
 * Ela permite adicionar, remover e acessar elementos de maneira eficiente. Esta lista pode armazenar
 * qualquer tipo de objeto e oferece funcionalidades típicas de listas, como adicionar ao final,
 * inserir em posições específicas, remover elementos, verificar a presença de elementos e mais.

 */
public class ListaEncadeada<T> {

    private No<T> cabeca;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    /**
     * Adiciona um elemento ao final da lista.
     */
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

    /**
     * Retorna o elemento na posição especificada.
     */
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

    /**
     * Verifica se a lista está vazia.
     */
    public boolean isEmpty() {
        return tamanho == 0;
    }

    /**
     * Retorna o número de elementos presentes na lista.
     */
    public int size() {
        return tamanho;
    }

    /**
     * Insere um valor em uma posição específica na lista.
     */
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

    /**
     * Adiciona todos os elementos de outra lista à lista atual.
     */
    public void addAll(ListaEncadeada<T> list) {
        No<T> atual = list.cabeca;
        while (atual != null) {
            append(atual.getValor());
            atual = atual.getProx();
        }
    }

    /**
     * Remove o elemento na posição especificada.
     */
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

    /**
     * Limpa todos os elementos da lista.
     */
    public boolean clear() {
        cabeca = null;
        tamanho = 0;
        return true;
    }

    /**
     * Retorna o índice da primeira ocorrência do valor fornecido.
     */
    public int indexOf(T value) {
        No<T> atual = cabeca;
        for (int i = 0; i < tamanho; i++) {
            if (atual.getValor().equals(value)) {
                return i;
            }
            atual = atual.getProx();
        }
        return -1;
    }

    /**
     * Verifica se o valor fornecido está presente na lista.
     */
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }
}
