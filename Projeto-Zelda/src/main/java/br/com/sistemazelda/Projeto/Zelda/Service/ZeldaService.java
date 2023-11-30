package br.com.sistemazelda.Projeto.Zelda.Service;
import br.com.sistemazelda.Projeto.Zelda.Model.ZeldaAPI;
import br.com.sistemazelda.Projeto.Zelda.Model.ZeldaListAPI;
import br.com.sistemazelda.Projeto.Zelda.Model.ZeldaModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class ZeldaService {
    private final WebClient webClient;
    public ZeldaService(WebClient.Builder builder){
        webClient = builder.baseUrl("https://zelda.fanapis.com/api/games").build();
    }

    public Flux<ZeldaAPI> getGames(){
        log.info("Buscando Jogos");
        return webClient
                .get()
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,error -> Mono.error(new RuntimeException("Verifique os parâmetros informados!")))
                .bodyToFlux(ZeldaAPI.class)
                ;
    }

    public Mono<ZeldaListAPI> getGameByID(String id){
        log.info("Buscando jogo pelo!");
        return webClient
                .get()
                .uri("/{game_id}", id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,error -> Mono.error(new RuntimeException("Verifique os parâmetros informados!")))
                .bodyToMono(ZeldaListAPI.class)
                ;
    }



}

//   private static final String apiGame = "https://zelda.fanapis.com/api/games";
// private static final String apiGameID = "https://zelda.fanapis.com/api/games/:game_ID";
