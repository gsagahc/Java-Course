import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
      

        // Fazer uma conexão http em busca dos 250 top filmes
        String url = "https://api.mocki.io/v2/549a5d8b"; // usando endereço alternativo
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
      
        //extrair só os dados que interessam (titulo, post, classificação)
        JsonParser parser = new JsonParser();

        List<Map<String, String>> listadeFilmes = parser.parse(body);
        System.out.println(listadeFilmes.size());
        System.out.println(listadeFilmes.get(0) );
        //manipular os dados.
        for (Map<String,String> filme : listadeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
            
            
        }

    }
}
