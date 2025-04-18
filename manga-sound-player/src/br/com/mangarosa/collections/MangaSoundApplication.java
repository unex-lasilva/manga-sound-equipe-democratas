package br.com.mangarosa.collections;

import java.util.Scanner;

public class MangaSoundApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Mantenha o scanner aqui
        MangaController controller = new MangaController();
        int opcao = 0;

        while (opcao != 5) { // Usando 5 conforme o menu completo
            System.out.println("MangaSound, o seu app de músicas");
            System.out.println("1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após o nextInt()

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Música ao Repositório");
                    System.out.print("Digite o título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o caminho do arquivo: ");
                    String path = scanner.nextLine();
                    System.out.print("Digite o nome do artista: ");
                    String nomeArtista = scanner.nextLine();

                    controller.adicionarMusica(titulo, path, nomeArtista);
                    System.out.println("Música adicionada com sucesso!");
                    break;

                case 2:
                    System.out.println("Criar Lista de Reprodução (Ainda não implementado)");
                    break;

                case 3:
                    System.out.println("Editar Lista de Reprodução (Ainda não implementado)");
                    break;

                case 4:
                    System.out.println("Executar Lista de Reprodução (Ainda não implementado)");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println(); // Adiciona uma linha em branco para melhor formatação
        }

        scanner.close(); // Fechamento do scanner após o loop
    }
}
