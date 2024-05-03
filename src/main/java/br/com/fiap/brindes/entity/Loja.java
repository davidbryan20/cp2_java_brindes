package br.com.fiap.brindes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Loja {

    private Long id;

    private String nome;

    private Set<Produto> produtosComercializados = new LinkedHashSet<>();

}
