package main.java.br.com.mangarosa;

public class ListaEncadeada {

    private No cabeca;
    private int tamanho;

    public ListaEncadeada() {
            this.cabeca = null;
            this.tamanho = 0;
        }


        public void append(Musica valor) {
            No novoNo = new No(valor);
            if (cabeca == null) {
                cabeca = novoNo;
            } else {
                No atual = cabeca;
                while (atual.getProx() != null) {
                    atual = atual.getProx();
                }
                atual.setProx(novoNo);
            }
            tamanho++;
        }


        public void remove(int posicao) {
            if (posicao < 0 || posicao >= tamanho) {
                throw new IndexOutOfBoundsException("Posição inválida.");
            }

            if (posicao == 0) {
                cabeca = cabeca.getProx();
            } else {
                No anterior = cabeca;
                for (int i = 0; i < posicao - 1; i++) {
                    anterior = anterior.getProx();
                }
                No atual = anterior.getProx();
                anterior.setProx(atual.getProx());
            }
            tamanho--;
        }


        public void inserir(int posicao, Musica valor) {
            if (posicao < 0 || posicao > tamanho) {
                throw new IndexOutOfBoundsException("Posição inválida.");
            }

            No novoNo = new No(valor);

            if (posicao == 0) {
                novoNo.setProx(cabeca);
                cabeca = novoNo;
            } else {
                No anterior = cabeca;
                for (int i = 0; i < posicao - 1; i++) {
                    anterior = anterior.getProx();
                }
                novoNo.setProx(anterior.getProx());
                anterior.setProx(novoNo);
            }
            tamanho++;
        }

        // Retorna o valor da posição
        public Musica get(int posicao) {
            if (posicao < 0 || posicao >= tamanho) {
                throw new IndexOutOfBoundsException("Posição inválida.");
            }

            No atual = cabeca;
            for (int i = 0; i < posicao; i++) {
                atual = atual.getProx();
            }
            return atual.getValor();
        }


        public int indexOf(Musica valor) {
            No atual = cabeca;
            int index = 0;
            while (atual != null) {
                if (atual.getValor().equals(valor)) {
                    return index;
                }
                atual = atual.getProx();
                index++;
            }
            return -1;
        }


        public boolean contains(Musica valor) {
            return indexOf(valor) != -1;
        }


        public int size() {
            return tamanho;
        }
    }





