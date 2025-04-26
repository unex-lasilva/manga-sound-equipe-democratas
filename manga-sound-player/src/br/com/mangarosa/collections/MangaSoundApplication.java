package br.com.mangarosa.collections;

import java.util.Scanner;

public class MangaSoundApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MangaController controller = new MangaController();

        System.out.println("MangaSound, o seu app de músicas");

        while (true) {
            System.out.println("\n1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após o número

            switch (escolha) {
                case 1:
                    System.out.println("Adicionar Música ao Repositório");
                    System.out.print("Digite o título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o caminho completo do arquivo (ex: C:/musicas/musica.wav): ");
                    String caminhoOriginal = scanner.nextLine();
                    System.out.print("Digite o nome do artista: ");
                    String artista = scanner.nextLine();
                    controller.adicionarMusica(titulo, caminhoOriginal, artista);
                    break;
                case 2:
                    System.out.println("Criar Lista de Reprodução");
                    System.out.print("Digite o nome da sua nova lista: ");
                    String nomeLista = scanner.nextLine();
                    controller.criarListaReproducao(nomeLista);
                    break;
                case 3:
                    System.out.println("Editar Lista de Reprodução");
                    controller.editarLista();
                    break;
                case 4:
                    System.out.println("Executar Lista de Reprodução");
                    System.out.print("Digite o nome da lista de reprodução para executar: ");
                    nomeLista = scanner.nextLine();
                    controller.produzirListaDeReproducao(nomeLista);

                    // Controle de reprodução em um loop separado
                    boolean controlando = true;
                    while (controlando) {
                        System.out.println("\nMúsica atual: " + controller.reprodutorLista.getMusicaAtualTitulo());
                        System.out.println("1. Pausar Música");
                        System.out.println("2. Continuar Música");
                        System.out.println("3. Parar Música");
                        System.out.println("4. Próxima Música");
                        System.out.println("5. Voltar Música");
                        System.out.println("6. Reiniciar Lista");
                        System.out.print("Escolha uma opção: ");

                        int controle = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha após o número

                        switch (controle) {
                            case 1:
                                controller.pausarMusica();
                                break;
                            case 2:
                                controller.executarMusica();
                                break;
                            case 3:
                                controller.pararMusica();
                                controlando = false;
                                break;
                            case 4:
                                controller.passarMusica();
                                break;
                            case 5:
                                controller.voltarMusica();
                                break;
                            case 6:
                                controller.reiniciarLista();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return; // Sai do loop e termina a aplicação
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
