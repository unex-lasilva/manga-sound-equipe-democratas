package br.com.mangarosa.collections;

import java.util.Objects;

/**
 * Classe que controla as operações de gerenciamento de músicas e listas de reprodução.
 */
public class MangaController {

    private ListaEncadeada<Musica> repositorioMusica;
    private ListaEncadeada<ListaReproducao> listasReproducao;
    private ListaEncadeada<String> artistas;
    private ReprodutorLista reprodutorLista;

    /**
     * Construtor que inicializa o repositório de músicas, a lista de reprodução,
     * a lista de artistas e o reprodutor de lista.
     */
    public MangaController() {
        this.repositorioMusica = new ListaEncadeada<Musica>();
        this.listasReproducao = new ListaEncadeada<ListaReproducao>();
        this.artistas = new ListaEncadeada<String>();
        this.reprodutorLista = new ReprodutorLista(); // Instanciando corretamente
    }

    /**
     * Adiciona uma música ao repositório de músicas.
     */
    public void adicionarMusica(String titulo, String path, String nomeArtista) {
        Objects.requireNonNull(titulo, "Título não pode ser nulo");
        Objects.requireNonNull(path, "Caminho não pode ser nulo");
        Objects.requireNonNull(nomeArtista, "Nome do artista não pode ser nulo");

        Musica novaMusica = new Musica(titulo, nomeArtista, path);
        this.repositorioMusica.append(novaMusica);
    }

    /**
     * Lista todas as músicas presentes no repositório de músicas.
     */
    public void listarMusicas() {
        if (this.repositorioMusica.isEmpty()) {
            System.out.println("Não há músicas no repositório.");
        } else {
            for (int i = 0; i < this.repositorioMusica.size(); i++) {
                Musica musica = (Musica) this.repositorioMusica.get(i);
                System.out.println("Título: " + musica.getTitulo() + ", Artista: " + musica.getArtista());
            }
        }
    }

    // Outros métodos serão implementados nas próximas etapas
}
