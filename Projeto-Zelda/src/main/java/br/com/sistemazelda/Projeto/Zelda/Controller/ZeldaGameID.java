package br.com.sistemazelda.Projeto.Zelda.Controller;

import br.com.sistemazelda.Projeto.Zelda.Model.ZeldaAPI;
import br.com.sistemazelda.Projeto.Zelda.Model.ZeldaListAPI;
import br.com.sistemazelda.Projeto.Zelda.Model.ZeldaModel;
import br.com.sistemazelda.Projeto.Zelda.Service.ZeldaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("webclient")
public class ZeldaGameID {

    ZeldaService zeldaService;
    @GetMapping("games")
    public Flux<ZeldaAPI> getAllGames(){
    return zeldaService.getGames();
    }

    @GetMapping("games/{id}")
    public Mono<ZeldaListAPI> getGameById(@PathVariable String id){
        return  zeldaService.getGameByID(id);
    }
}
