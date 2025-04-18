package br.com.mangarosa.collections;


/**
 * Classe que representa uma música no sistema.
 */
public class Musica {

    private String titulo;
    private int duracao; // em segundos
    private String path; // caminho do arquivo de áudio
    private String artista;

    /**
     * Construtor padrão que inicializa os atributos com valores padrão.
     */
    public Musica() {
        this.titulo = "";
        this.duracao = 0;
        this.path = "";
        this.artista = "";
    }

    /**
     * Construtor que inicializa os atributos com os valores fornecidos.
     */
    public Musica(String titulo, String artista, String path) {
        this.titulo = titulo;
        this.artista = artista;
        this.path = path;
        this.duracao = 0; // Pode ser inicializado com 0 ou um valor padrão, se necessário
    }

    /**
     * Obtém o título da música.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtém a duração da música.
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Obtém o caminho do arquivo de áudio da música.
     */
    public String getPath() {
        return path;
    }

    /**
     * Obtém o nome do artista da música.
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Define o título da música.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Define a duração da música.
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Define o caminho do arquivo de áudio da música.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Define o nome do artista da música.
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }
}