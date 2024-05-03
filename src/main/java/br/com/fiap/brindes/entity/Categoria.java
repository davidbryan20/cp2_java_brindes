package br.com.fiap.brindes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Categoria {

    private Long id;

    //Canetas
    //Camisetas
    //Canecas
    //Mochilas
    private String nome;

}
