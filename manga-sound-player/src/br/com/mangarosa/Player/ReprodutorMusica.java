package br.com.mangarosa.Player;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReprodutorMusica {
    private Long currentFrame;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private String status;
    private String filePath;

    public ReprodutorMusica(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.filePath = filePath;
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play() {
        clip.start();
        status = "play";
    }

    public void pause() {
        if (status.equals("paused")) return;
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void resume() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("play")) return;
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    private void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
