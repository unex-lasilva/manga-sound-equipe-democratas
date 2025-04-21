package br.com.mangarosa.collections;

public class ListaReproducao {
    private String titulo;
    private ListaEncadeada<Musica> lista;

    // Construtor da lista de reprodução
    public ListaReproducao(String titulo) {
        this.titulo = titulo;
        this.lista = new ListaEncadeada<>();
    }

    // Adiciona uma música à lista
    public void addMusica(Musica musica) {
        lista.append(musica);
    }

    // Remove uma música da posição especificada
    public boolean removerMusica(int posicao) {
        return lista.remove(posicao);
    }

    // Insere uma música na posição especificada
    public void inserirMusicaEm(int posicao, Musica musica) {
        lista.insertAt(posicao, musica);
    }

    // Verifica se a lista está vazia
    public boolean isVazia() {
        return lista.isEmpty();
    }

    // Retorna o número de músicas na lista
    public int tamanho() {
        return lista.size();
    }

    // Cria uma nova lista a partir de outra lista
    public void criarListaApartirDe(ListaReproducao outraLista) {
        for (int i = 0; i < outraLista.tamanho(); i++) {
            Musica musica = outraLista.obterMusica(i);
            this.addMusica(musica);
        }
    }

    // Retorna a posição de uma música na lista
    public int posicaoDa(Musica musica) {
        return lista.indexOf(musica);
    }

    // Verifica se a lista contém uma música específica
    public boolean contemMusica(Musica musica) {
        return lista.contains(musica);
    }

    // Limpa a lista, removendo todas as músicas
    public boolean limparLista() {
        return lista.clear();
    }

    // Obtém a música na posição especificada
    public Musica obterMusica(int posicao) {
        if (posicao >= 0 && posicao < lista.size()) {
            return lista.get(posicao);
        }
        return null;
    }

    // Retorna o título da lista de reprodução
    public String getTitulo() {
        return titulo;
    }

    // Define um novo título para a lista de reprodução
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Exibe todas as músicas da lista
    public void exibirMusicas() {
        if (isVazia()) {
            System.out.println("A lista de reprodução está vazia.");
        } else {
            for (int i = 0; i < tamanho(); i++) {
                Musica musica = obterMusica(i);
                System.out.println(musica.getTitulo() + " - " + musica.getArtista());
            }
        }
    }

    // Move uma música de uma posição para outra
    public void moverMusica(int indiceOrigem, int indiceDestino) {
        if (indiceOrigem < 0 || indiceOrigem >= tamanho() || indiceDestino < 0 || indiceDestino >= tamanho()) {
            System.out.println("Índices inválidos.");
            return;
        }

        Musica musica = obterMusica(indiceOrigem);
        removerMusica(indiceOrigem);
        inserirMusicaEm(indiceDestino, musica);
        System.out.println("Música movida para a posição " + indiceDestino);
    }
}
