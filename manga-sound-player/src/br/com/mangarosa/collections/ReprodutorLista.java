package br.com.mangarosa.collections;

import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ReprodutorLista {

    private ListaReproducao listaReproducao;
    private String status;  // "play", "paused", etc.
    private Clip clip;      // Para tocar a música
    private Long currentFrame; // Para retomar de onde parou a música
    private AudioInputStream audioInputStream;

    // Construtor
    public ReprodutorLista() {
        this.status = "stopped";  // Inicialmente parado
    }

    // Construtor com a lista de reprodução
    public ReprodutorLista(ListaReproducao listaReproducao) {
        this.listaReproducao = listaReproducao;
        this.status = "stopped";
    }

    public void setListaReproducao(ListaReproducao listaReproducao) {
        this.listaReproducao = listaReproducao;
    }

    public ListaReproducao getListaReproducao() {
        return listaReproducao;
    }

    // Método para tocar a música
    public void play() {
        if (this.listaReproducao.isVazia()) {
            System.out.println("Lista de reprodução vazia!");
            return;
        }

        // Tocar a primeira música da lista
        Musica musica = (Musica) listaReproducao.obterMusica(0);
        try {
            // Criar o fluxo de áudio
            File file = new File(musica.getPath());
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Iniciar a reprodução
            clip.start();
            status = "playing";
            System.out.println("Tocando: " + musica.getTitulo());

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Erro ao tentar tocar a música: " + e.getMessage());
        }
    }

    // Método para pausar a música
    public void pause() {
        if (status.equals("paused")) {
            System.out.println("A música já está pausada.");
            return;
        }
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
        System.out.println("Música pausada.");
    }

    // Método para continuar a música
    public void resume() {
        if (status.equals("playing")) {
            System.out.println("A música já está tocando.");
            return;
        }
        try {
            clip.close();
            audioInputStream = AudioSystem.getAudioInputStream(new File(((Musica) listaReproducao.obterMusica(0)).getPath()));
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(currentFrame);
            clip.start();
            status = "playing";
            System.out.println("Música retomada.");
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Erro ao continuar a música: " + e.getMessage());
        }
    }

    // Método para parar a música
    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
        status = "stopped";
        System.out.println("Música parada.");
    }

    // Método para reiniciar a música
    public void restart() {
        stop();
        play();
    }

    // Método para pular para uma posição específica
    public void jump(long position) {
        if (position >= 0 && position < clip.getMicrosecondLength()) {
            currentFrame = position;
            clip.setMicrosecondPosition(position);
            System.out.println("Pulando para: " + position);
        }
    }
}
