package br.com.mangarosa.collections;

public class ListaReproducao {

    private ListaEncadeada<Musica> listaMusicas;
    private String nome;

    // Construtor
    public ListaReproducao(String nome) {
        this.nome = nome;
        this.listaMusicas = new ListaEncadeada<>();
    }

    // Adicionar música
    public void adicionarMusica(Musica musica) {
        listaMusicas.append(musica);
    }

    // Remover música pelo índice
    public void removerMusica(Musica musica) {
        for (int i = 0; i < listaMusicas.size(); i++) {
            Musica m = (Musica) listaMusicas.get(i);
            if (m.equals(musica)) {  // Verificando se a música é igual
                listaMusicas.remove(i);  // Remove o índice onde a música foi encontrada
                System.out.println("Música " + musica.getTitulo() + " removida da lista.");
                return;
            }
        }
        System.out.println("Música não encontrada na lista.");
    }

    // Mover música de um índice para outro
    public void moverMusica(int indiceOriginal, int novaPosicao) {
        if (indiceOriginal < 0 || novaPosicao < 0 || indiceOriginal >= listaMusicas.size() || novaPosicao >= listaMusicas.size()) {
            System.out.println("Índices inválidos.");
            return;
        }

        Musica musica = (Musica) listaMusicas.get(indiceOriginal);
        listaMusicas.remove(indiceOriginal);
        listaMusicas.insert(musica, novaPosicao);
        System.out.println("Música movida para a nova posição.");
    }

    // Método para verificar se a lista de reprodução está vazia
    public boolean isVazia() {
        return listaMusicas.isEmpty();
    }

    // Método para obter a música pela posição na lista
    public Musica obterMusica(int posicao) {
        if (posicao >= 0 && posicao < listaMusicas.size()) {
            return (Musica) listaMusicas.get(posicao);
        } else {
            System.out.println("Posição inválida.");
            return null;
        }
    }

    // Método para retornar o nome da lista de reprodução
    public String getNome() {
        return nome;
    }

    // Método para retornar o tamanho da lista de músicas
    public int size() {
        return listaMusicas.size();
    }

    // Método para retornar a música na posição específica
    public Object get(int index) {
        return listaMusicas.get(index);
    }

    // Método para verificar se a música está presente na lista
    public boolean contemMusica(Musica musica) {
        return listaMusicas.contains(musica);
    }

    // Método para limpar a lista de reprodução
    public void limparLista() {
        listaMusicas.clear();
        System.out.println("Lista de reprodução limpa.");
    }

    // Método para pegar o índice da música na lista
    public int posicaoDa(Musica musica) {
        return listaMusicas.indexOf(musica);
    }
}
