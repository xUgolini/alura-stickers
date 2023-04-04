import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */

    // colorindo o terminal
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_SEMTARJA = "\u001b[m";
    public static final String ANSI_WHITE = "\u001b[1m";
    public static final String ANSI_RED = "\u001b[41m";

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url ="https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // extrair só os dados que interessam (Titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados 
        String emoji = "\u2B49";
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println(ANSI_WHITE +"Titulo:" + ANSI_SEMTARJA + " " + filme.get("title"));
            System.out.println(ANSI_WHITE +"URL da Imagem:" + ANSI_SEMTARJA + " "+filme.get("image"));
            int rating = Integer.parseInt(filme.get("imDbRating").split("\\.")[0]);
            System.out.println(ANSI_RED +"Rating: "+filme.get("imDbRating") + ANSI_SEMTARJA);

            for (int i=0; i<rating; i++){
                System.out.print(ANSI_YELLOW + emoji + ANSI_RESET);
            }
            
            System.out.println();
        }
    } 

}
