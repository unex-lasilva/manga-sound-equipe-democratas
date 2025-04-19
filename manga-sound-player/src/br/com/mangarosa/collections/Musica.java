package br.com.mangarosa.collections;

public class Musica {

    private String titulo;
    private int duracao;
    private String path;
    private String artista;

    public Musica() {
        this.titulo = "";
        this.duracao = 0;
        this.path = "";
        this.artista = "";
    }

    public Musica(String titulo, String artista, String path) {
        this.titulo = titulo;
        this.artista = artista;
        this.path = path;
        this.duracao = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getPath() {
        return path;
    }

    public String getArtista() {
        return artista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
