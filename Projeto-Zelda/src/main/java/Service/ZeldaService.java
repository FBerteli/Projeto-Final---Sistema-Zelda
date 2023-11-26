package Service;
import org.springframework.web.reactive.function.client.WebClient;
public class ZeldaService {
    public static void main(String[] args) {
        String apiGame = "https://zelda.fanapis.com/api/games";
        String apiGameID = "https://zelda.fanapis.com/api/games/:game_id";
        WebClient webClient = WebClient.create();

        String resposta = webClient.get()
                .uri(apiGameID)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("Resposta da API:" + resposta);
    }
}
