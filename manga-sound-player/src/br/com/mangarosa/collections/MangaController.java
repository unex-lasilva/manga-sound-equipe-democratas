package br.com.mangarosa.collections;

import java.io.File;
import java.util.Scanner;

public class MangaController {
    private ListaEncadeada<Musica> repositorioMusica;
    private ListaEncadeada<ListaReproducao> listasReproducao;
    private ListaEncadeada<String> artistas;
    public ReprodutorLista reprodutorLista;

    // Construtor do controlador
    public MangaController() {
        this.reprodutorLista = new ReprodutorLista();
        this.listasReproducao = new ListaEncadeada<>();
        this.repositorioMusica = new ListaEncadeada<>();
        this.artistas = new ListaEncadeada<>();
    }

    // Adiciona uma música ao repositório
    public void adicionarMusica(String titulo, String path, String nomeArtista) {
        File arquivoOriginal = new File(path);
        if (!arquivoOriginal.exists() || arquivoOriginal.isDirectory()) {
            System.out.println("Erro: Caminho do arquivo inválido.");
            return;
        }

        Musica musica = new Musica(titulo, nomeArtista, path);
        if (musica.getPath() != null) {
            repositorioMusica.append(musica);

            // Adiciona artista se não existir
            if (!artistas.contains(nomeArtista)) {
                artistas.append(nomeArtista);
            }

            System.out.println("Música \"" + titulo + "\" adicionada ao repositório com sucesso!");
        } else {
            System.out.println("Erro ao copiar a música para o repositório.");
        }
    }

    // Cria uma nova lista de reprodução
    public void criarListaReproducao(String titulo) {
        // Verifica se já existe uma lista com esse título
        for (int i = 0; i < listasReproducao.size(); i++) {
            if (listasReproducao.get(i).getTitulo().equals(titulo)) {
                System.out.println("Lista de reprodução com esse nome já existe.");
                return;
            }
        }

        ListaReproducao lista = new ListaReproducao(titulo);
        listasReproducao.append(lista);
        System.out.println("Lista de reprodução \"" + titulo + "\" criada.");
    }

    // Exclui uma lista de reprodução
    public void excluirListaReproducao(String titulo) {
        for (int i = 0; i < listasReproducao.size(); i++) {
            if (listasReproducao.get(i).getTitulo().equals(titulo)) {
                listasReproducao.remove(i);
                System.out.println("Lista de reprodução \"" + titulo + "\" excluída.");
                return;
            }
        }
        System.out.println("Lista de reprodução não encontrada.");
    }

    // Adiciona uma música a uma lista de reprodução
    public void adicionarMusicaListaReproducao(String tituloMusica, String tituloLista) {
        ListaReproducao lista = buscarListaReproducao(tituloLista);
        if (lista == null) {
            System.out.println("Lista de reprodução não encontrada.");
            return;
        }

        Musica musica = buscarMusicaPorTitulo(tituloMusica);
        if (musica == null) {
            System.out.println("Música não encontrada no repositório.");
            return;
        }

        lista.addMusica(musica);
        System.out.println("Música adicionada à lista de reprodução.");
    }

    // Adiciona uma música a uma lista de reprodução em uma posição específica
    public void adicionarMusicaListaReproducaoEmPosicao(String tituloMusica, String tituloLista, int posicao) {
        ListaReproducao lista = buscarListaReproducao(tituloLista);
        if (lista == null) {
            System.out.println("Lista de reprodução não encontrada.");
            return;
        }

        Musica musica = buscarMusicaPorTitulo(tituloMusica);
        if (musica == null) {
            System.out.println("Música não encontrada no repositório.");
            return;
        }

        lista.inserirMusicaEm(posicao, musica);
        System.out.println("Música adicionada à lista de reprodução na posição " + posicao + ".");
    }

    // Remove uma música de uma lista de reprodução
    public void removerMusicaListaReproducao(String tituloMusica, String tituloLista) {
        ListaReproducao lista = buscarListaReproducao(tituloLista);
        if (lista == null) {
            System.out.println("Lista de reprodução não encontrada.");
            return;
        }

        Musica musica = buscarMusicaPorTitulo(tituloMusica);
        if (musica == null) {
            System.out.println("Música não encontrada no repositório.");
            return;
        }

        int posicao = lista.posicaoDa(musica);
        if (posicao >= 0) {
            lista.removerMusica(posicao);
            System.out.println("Música removida da lista de reprodução.");
        } else {
            System.out.println("Música não encontrada na lista.");
        }
    }

    // Remove uma música de uma lista de reprodução em uma posição específica
    public void removerMusicaListaReproducaoEmPosicao(String tituloLista, int posicao) {
        ListaReproducao lista = buscarListaReproducao(tituloLista);
        if (lista == null) {
            System.out.println("Lista de reprodução não encontrada.");
            return;
        }

        if (lista.removerMusica(posicao)) {
            System.out.println("Música removida da posição " + posicao + ".");
        } else {
            System.out.println("Posição inválida.");
        }
    }

    // Inicia a reprodução de uma lista
    public void produzirListaDeReproducao(String tituloLista) {
        ListaReproducao lista = buscarListaReproducao(tituloLista);
        if (lista == null || lista.isVazia()) {
            System.out.println("Lista de reprodução não encontrada ou está vazia.");
            return;
        }

        reprodutorLista.setListaReproducao(lista);
        reprodutorLista.play();
    }

    // Pausa a reprodução da música atual
    public void pausarMusica() {
        reprodutorLista.pausar();
    }

    // Retoma a reprodução da música pausada
    public void executarMusica() {
        reprodutorLista.resume();
    }

    // Volta para a música anterior ou reinicia a atual
    public void voltarMusica() {
        reprodutorLista.voltar();
    }

    // Avança para a próxima música
    public void passarMusica() {
        reprodutorLista.proxima();
    }

    // Reinicia a lista de reprodução
    public void reiniciarLista() {
        reprodutorLista.restartLista();
    }

    // Para a reprodução da música atual
    public void pararMusica() {
        reprodutorLista.stop();
    }

    // Busca uma música pelo título
    private Musica buscarMusicaPorTitulo(String titulo) {
        for (int i = 0; i < repositorioMusica.size(); i++) {
            Musica musica = repositorioMusica.get(i);
            if (musica != null && musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        return null;
    }

    // Busca uma lista de reprodução pelo título
    private ListaReproducao buscarListaReproducao(String titulo) {
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lista = listasReproducao.get(i);
            if (lista.getTitulo().equals(titulo)) {
                return lista;
            }
        }
        return null;
    }

    // Verifica se uma música está tocando
    public boolean estaTocando() {
        return reprodutorLista.estaTocando();
    }

    // Verifica se uma música está pausada
    public boolean estaPausado() {
        return reprodutorLista.estaPausado();
    }

    // Interface para editar uma lista de reprodução
    public void editarLista() {
        if (listasReproducao.isEmpty()) {
            System.out.println("Nenhuma lista de reprodução disponível.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Listas disponíveis:");
        for (int i = 0; i < listasReproducao.size(); i++) {
            System.out.println((i + 1) + ". " + listasReproducao.get(i).getTitulo());
        }

        System.out.print("Digite o número da lista que deseja editar: ");
        int escolhaLista = scanner.nextInt();
        scanner.nextLine();

        if (escolhaLista < 1 || escolhaLista > listasReproducao.size()) {
            System.out.println("Número inválido.");
            return;
        }

        ListaReproducao lista = listasReproducao.get(escolhaLista - 1);
        boolean editando = true;

        while (editando) {
            System.out.println("\nEditando lista: " + lista.getTitulo());
            System.out.println("1. Adicionar música");
            System.out.println("2. Remover música");
            System.out.println("3. Mover música de lugar");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da música a adicionar: ");
                    String tituloAdd = scanner.nextLine();
                    Musica musicaAdd = buscarMusicaPorTitulo(tituloAdd);
                    if (musicaAdd != null) {
                        lista.addMusica(musicaAdd);
                        System.out.println("Música adicionada.");
                    } else {
                        System.out.println("Música não encontrada no repositório.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o título da música a remover: ");
                    String tituloRemover = scanner.nextLine();
                    Musica musicaRemover = buscarMusicaPorTitulo(tituloRemover);
                    if (musicaRemover != null) {
                        int posicao = lista.posicaoDa(musicaRemover);
                        if (posicao >= 0) {
                            lista.removerMusica(posicao);
                            System.out.println("Música removida.");
                        } else {
                            System.out.println("Música não encontrada na lista.");
                        }
                    } else {
                        System.out.println("Música não encontrada no repositório.");
                    }
                    break;
                case 3:
                    if (lista.tamanho() == 0) {
                        System.out.println("A lista está vazia.");
                        break;
                    }

                    for (int i = 0; i < lista.tamanho(); i++) {
                        Musica musica = lista.obterMusica(i);
                        System.out.println((i + 1) + ". " + musica.getTitulo() + " - " + musica.getArtista());
                    }

                    System.out.print("Digite o número da música a mover: ");
                    int indiceOrigem = scanner.nextInt() - 1;
                    System.out.print("Digite a nova posição da música: ");
                    int novaPosicao = scanner.nextInt() - 1;

                    if (indiceOrigem < 0 || indiceOrigem >= lista.tamanho() ||
                            novaPosicao < 0 || novaPosicao >= lista.tamanho()) {
                        System.out.println("Índices inválidos.");
                    } else {
                        lista.moverMusica(indiceOrigem, novaPosicao);
                    }
                    break;
                case 4:
                    editando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
