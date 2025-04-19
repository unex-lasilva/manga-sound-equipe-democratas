package br.com.mangarosa.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MangaController {

    // Atributos
    private Map<String, ListaReproducao> listasReproducao;
    private ListaEncadeada<Musica> repositorioMusicas;

    // Construtor
    public MangaController() {
        this.listasReproducao = new HashMap<>(); // Usando HashMap para armazenar as listas de reprodução
        this.repositorioMusicas = new ListaEncadeada<>(); // Repositório de músicas
    }

    // Método para adicionar música ao repositório
    public void adicionarMusica(String titulo, String caminho, String artista) {
        Musica musica = new Musica(titulo, caminho, artista);
        repositorioMusicas.append(musica);
        System.out.println("Música " + titulo + " adicionada ao repositório.");
    }

    // Método para criar uma nova lista de reprodução
    public void criarListaDeReproducao(String nomeLista) {
        if (listasReproducao.containsKey(nomeLista)) {
            System.out.println("Lista de reprodução com esse nome já existe.");
        } else {
            ListaReproducao lista = new ListaReproducao(nomeLista);
            listasReproducao.put(nomeLista, lista);
            System.out.println("Lista de reprodução " + nomeLista + " criada.");
        }
    }

    // Método para editar uma lista de reprodução
    public void editarLista(String nomeLista) {
        if (listasReproducao.containsKey(nomeLista)) {
            Scanner scanner = new Scanner(System.in);
            ListaReproducao lista = listasReproducao.get(nomeLista);

            while (true) {
                System.out.println("\nEdição da lista " + nomeLista);
                System.out.println("1. Adicionar música");
                System.out.println("2. Remover música");
                System.out.println("3. Mover música");
                System.out.println("4. Voltar");

                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (escolha) {
                    case 1:
                        System.out.print("Digite o título da música a adicionar: ");
                        String titulo = scanner.nextLine();
                        Musica musica = buscarMusicaPorTitulo(titulo);
                        if (musica != null) {
                            lista.adicionarMusica(musica);
                            System.out.println("Música " + titulo + " adicionada à lista.");
                        } else {
                            System.out.println("Música não encontrada no repositório.");
                        }
                        break;

                    case 2:
                        System.out.print("Digite o título da música a remover: ");
                        titulo = scanner.nextLine();
                        musica = buscarMusicaPorTitulo(titulo);
                        if (musica != null) {
                            lista.removerMusica(musica);
                        } else {
                            System.out.println("Música não encontrada no repositório.");
                        }
                        break;

                    case 3:
                        System.out.print("Digite o índice da música a mover: ");
                        int indiceOriginal = scanner.nextInt();
                        System.out.print("Digite a nova posição: ");
                        int novaPosicao = scanner.nextInt();
                        lista.moverMusica(indiceOriginal, novaPosicao);
                        break;

                    case 4:
                        return; // Voltar ao menu principal

                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } else {
            System.out.println("Lista de reprodução não encontrada.");
        }
    }

    // Método para buscar uma música no repositório pelo título
    private Musica buscarMusicaPorTitulo(String titulo) {
        for (int i = 0; i < repositorioMusicas.size(); i++) {
            Musica musica = (Musica) repositorioMusicas.get(i);
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        return null;
    }

    // Método para executar a lista de reprodução (a execução pode ser implementada conforme necessidade)
    public void executarLista(String nomeLista) {
        if (listasReproducao.containsKey(nomeLista)) {
            ListaReproducao lista = listasReproducao.get(nomeLista);
            System.out.println("Executando a lista " + nomeLista);
            // Aqui você pode adicionar o código para reproduzir as músicas da lista
        } else {
            System.out.println("Lista de reprodução não encontrada.");
        }
    }

    // Método para buscar uma lista de reprodução por título
    public ListaReproducao buscarListaReproducao(String titulo) {
        return listasReproducao.get(titulo); // Retorna a lista de reprodução ou null se não encontrar
    }

    // Método para iniciar a reprodução de uma lista de reprodução
    public void produzirListaDeReproducao(String tituloLista) {
        ListaReproducao lista = buscarListaReproducao(tituloLista);
        if (lista != null) {
            ReprodutorLista reprodutor = new ReprodutorLista(lista);
            reprodutor.play(); // Inicia a reprodução da lista
        } else {
            System.out.println("Lista de reprodução não encontrada.");
        }
    }
}
