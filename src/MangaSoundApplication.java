import java.util.Scanner;

public class MangaSoundApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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


        }
    }
}
