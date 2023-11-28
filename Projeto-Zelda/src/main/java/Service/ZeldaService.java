package Service;
import br.com.sistemazelda.Projeto.Zelda.Model.ZeldaModel;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import java.util.*;
public class ZeldaService {
    private static final String apiGame = "https://zelda.fanapis.com/api/games";
    private static final String apiGameID = "https://zelda.fanapis.com/api/games/:game_ID";
    public static void main(String[] args) {
            WebClient webClient = WebClient.create(apiGame);

            // Faz a chamada à API de forma reativa
            Flux<ZeldaModel> responseArray = webClient.get()
                    .retrieve()
                    .bodyToFlux(ZeldaModel.class);

            // Coleta os objetos em uma lista
            List<ZeldaModel> dataList = responseArray.collectList().block();

            // Agora, 'dataList' contém os objetos Java representando os dados da API em forma de lista
            for (ZeldaModel data : dataList) {
                System.out.println("Objeto da API: " + data);
            }
        System.out.println(dataList.size());
    }
}

