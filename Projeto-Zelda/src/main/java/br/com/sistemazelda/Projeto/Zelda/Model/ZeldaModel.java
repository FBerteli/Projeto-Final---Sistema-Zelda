package br.com.sistemazelda.Projeto.Zelda.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ZeldaModel {
    private String nomeGame;
    private String descricaoGame;
    private String desenvolvedor;
    private String distruibuidora;
    private String dataLancamento;
    private long id;
}
