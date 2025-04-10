public class MangaController {

    private ListaEncadeada<ListaReproducao> listasReproducao;
    private ListaEncadeada<Musica> repositorioMusica;
    private ListaEncadeada<String> artistas;
    private ReprodutorLista reprodutorLista;

    public MangaController(){

        this.repositorioMusica = new ListaEncadeada<>();
        this.listasReproducao = new ListaEncadeada<>();
        this.artistas = new ListaEncadeada<>();
        this.reprodutorLista = null;
    }

}

