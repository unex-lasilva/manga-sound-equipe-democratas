package br.com.mangarosa.collections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Musica {
    private String titulo;
    private int duracao; // duração em segundos
    private String path;
    private String artista;

    // Construtor padrão
    public Musica() {
        this.titulo = "";
        this.duracao = 0;
        this.path = "";
        this.artista = "";
    }

    // Construtor com parâmetros
    public Musica(String titulo, String artista, String path) {
        this.titulo = titulo;
        this.artista = artista;
        this.path = path;
        this.duracao = 0;

        // Cria diretório do repositório se não existir
        File repoDir = new File("repositorio");
        if (!repoDir.exists()) {
            repoDir.mkdir();
        }

        // Verifica se o arquivo original existe
        File originalFile = new File(path);
        if (!originalFile.exists()) {
            System.out.println("Arquivo original não encontrado: " + path);
            return;
        }

        // Copia o arquivo para o repositório
        File copiedFile = new File(repoDir, originalFile.getName());
        try {
            Files.copy(originalFile.toPath(), copiedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            this.path = copiedFile.getAbsolutePath(); // Atualiza o path para o arquivo no repositório
        } catch (IOException e) {
            System.out.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }

    // Retorna o título da música
    public String getTitulo() {
        return titulo;
    }

    // Retorna a duração da música em segundos
    public int getDuracao() {
        return duracao;
    }

    // Retorna o caminho do arquivo da música
    public String getPath() {
        return path;
    }

    // Retorna o nome do artista
    public String getArtista() {
        return artista;
    }
}
