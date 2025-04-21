package br.com.mangarosa.collections;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReprodutorLista {
    private ListaReproducao listaReproducao;
    private String status; // "playing", "paused", "stopped"
    private Clip clip;
    private long currentFrame;
    private AudioInputStream audioInputStream;
    private int indiceAtual;

    // Construtor padrão
    public ReprodutorLista() {
        this.status = "stopped";
        this.indiceAtual = 0;
    }

    // Construtor com lista de reprodução
    public ReprodutorLista(ListaReproducao listaReproducao) {
        this.listaReproducao = listaReproducao;
        this.status = "stopped";
        this.indiceAtual = 0;
    }

    // Define a lista de reprodução atual
    public void setListaReproducao(ListaReproducao lista) {
        this.listaReproducao = lista;
        this.indiceAtual = 0;
    }

    // Retorna a lista de reprodução atual
    public ListaReproducao getListaReproducao() {
        return listaReproducao;
    }

    // Inicia a reprodução da música atual
    public void play() {
        if (listaReproducao == null || listaReproducao.isVazia()) {
            System.out.println("Lista de reprodução vazia ou nula!");
            return;
        }

        try {
            if (clip != null && clip.isOpen()) {
                clip.stop();
                clip.close();
            }

            Musica musica = listaReproducao.obterMusica(indiceAtual);
            if (musica == null || musica.getPath() == null) {
                System.out.println("Erro: Música ou caminho inválido.");
                return;
            }

            File file = new File(musica.getPath());
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(0);
            clip.start();
            status = "playing";
            System.out.println("Tocando: " + musica.getTitulo());
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Erro ao tentar tocar a música: " + e.getMessage());
        }
    }

    // Pausa a reprodução da música atual
    public void pausar() {
        if (clip == null || !status.equals("playing")) {
            System.out.println("Nenhuma música está sendo reproduzida.");
            return;
        }

        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
        System.out.println("Música pausada.");
    }

    // Reinicia a música atual do início
    public void restartMusical() {
        if (clip != null) {
            clip.setMicrosecondPosition(0);
            clip.start();
            status = "playing";
            System.out.println("Música reiniciada.");
        }
    }

    // Reinicia a lista de reprodução do início
    public void restartLista() {
        indiceAtual = 0;
        stop();
        play();
        System.out.println("Lista reiniciada.");
    }

    // Para a reprodução da música atual
    public void stop() {
        if (clip != null) {
            currentFrame = 0L;
            clip.stop();
            clip.close();
        }

        status = "stopped";
        System.out.println("Música parada.");
    }

    // Retoma a reprodução de uma música pausada
    public void resume() {
        if (clip == null || !status.equals("paused")) {
            System.out.println("Nenhuma música está pausada.");
            return;
        }

        try {
            clip.close();
            Musica musica = listaReproducao.obterMusica(indiceAtual);
            audioInputStream = AudioSystem.getAudioInputStream(new File(musica.getPath()));
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(currentFrame);
            clip.start();
            status = "playing";
            System.out.println("Música retomada.");
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Erro ao retomar a música: " + e.getMessage());
        }
    }

    // Avança para a próxima música na lista
    public void proxima() {
        if (listaReproducao == null || listaReproducao.isVazia()) {
            System.out.println("Lista de reprodução vazia!");
            return;
        }

        if (indiceAtual + 1 < listaReproducao.tamanho()) {
            indiceAtual++;
            stop();
            play();
        } else {
            System.out.println("Você está na última música da lista.");
        }
    }

    // Volta para a música anterior ou reinicia a atual
    public void voltar() {
        if (listaReproducao == null || listaReproducao.isVazia()) {
            System.out.println("Lista de reprodução vazia!");
            return;
        }

        if (estaTocandoHaMaisDe10Segundos()) {
            // Se a música estiver tocando há mais de 10 segundos, reinicia a música atual
            restartMusical();
            System.out.println("Reiniciando música atual.");
        } else if (indiceAtual - 1 >= 0) {
            // Se não, volta para a música anterior
            indiceAtual--;
            stop();
            play();
        } else {
            System.out.println("Você está na primeira música da lista.");
        }
    }

    // Verifica se a música está tocando há mais de 10 segundos
    public boolean estaTocandoHaMaisDe10Segundos() {
        if (clip != null && status.equals("playing")) {
            return clip.getMicrosecondPosition() > 10_000_000; // 10 segundos em microssegundos
        }
        return false;
    }

    // Verifica se uma música está tocando
    public boolean estaTocando() {
        return status.equals("playing");
    }

    // Verifica se uma música está pausada
    public boolean estaPausado() {
        return status.equals("paused");
    }

    // Retorna o status atual do reprodutor
    public String getStatus() {
        return status;
    }

    // Retorna o título da música atual
    public String getMusicaAtualTitulo() {
        if (listaReproducao == null || listaReproducao.isVazia()) {
            return "Nenhuma música tocando";
        }

        Musica musica = listaReproducao.obterMusica(indiceAtual);
        return musica != null ? musica.getTitulo() : "Música inválida";
    }
}
