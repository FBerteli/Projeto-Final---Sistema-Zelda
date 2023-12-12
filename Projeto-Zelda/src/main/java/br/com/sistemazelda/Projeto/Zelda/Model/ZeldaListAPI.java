package br.com.sistemazelda.Projeto.Zelda.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ZeldaListAPI {
        private Boolean success;
        private Integer count;
        private ZeldaModel data;
    }