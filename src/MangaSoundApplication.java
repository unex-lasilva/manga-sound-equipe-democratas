import java.util.Scanner;

public class MangaSoundApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MangaController controller = new MangaController();
        int opcao = 0;

        while (opcao != 5) {

            System.out.println("MangaSound, o seu app de musicas");
            System.out.println("1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Adicionar Música ao Repositório");
                    break;

                case 2:
                    System.out.println("Criar Lista de Reprodução");
                    break;

                case 3:
                    System.out.println("Editar Lista de Reprodução");
                    break;

                case 4:
                    System.out.println("Executar Lista de Reprodução");
                    break;

                case 5:
                    System.out.println("Sair");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }
        }
        scanner.close();
    }
}
