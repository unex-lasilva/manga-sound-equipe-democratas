package br.com.mangarosa.Player;

import java.util.Scanner;

public class TesteReprodutor {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite o caminho completo do arquivo .wav:");
            String caminho = sc.nextLine();

            ReprodutorMusica player = new ReprodutorMusica(caminho);
            player.play();

            int opcao;
            do {
                System.out.println("\n1. Pausar\n2. Retomar\n3. Parar\n4. Sair");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1 -> player.pause();
                    case 2 -> player.resume();
                    case 3 -> player.stop();
                }
            } while (opcao != 4);

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao tocar o áudio.");
        }
    }
}
