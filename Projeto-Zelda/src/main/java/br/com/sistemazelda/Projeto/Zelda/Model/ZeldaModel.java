package br.com.sistemazelda.Projeto.Zelda.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ZeldaModel {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
    private String id;
}
