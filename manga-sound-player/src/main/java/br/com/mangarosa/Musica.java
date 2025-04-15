package main.java.br.com.mangarosa;

public class Musica {

    private String titulo;
    private int duracao;
    private String path;
    private String artista;


    //constructor:
    public Musica(String titulo, String path, int duracao, String artista) {
        this.titulo = titulo;
        this.path = path;
        this.artista = artista;
        this.duracao = duracao;

    }

    //getter

    public String getTitulo() {
        return this.titulo;

    }

    public String getPath() {
        return this.path;
    }

    public String getArtista() {
        return this.artista;
    }

    public int getDuracao() {
        return this.duracao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nArtista: " + artista +
                "\nDuração: " + duracao + " segundos" +
                "\nCaminho do arquivo: " + path;
    }

}
