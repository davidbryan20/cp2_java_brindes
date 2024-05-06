package br.com.fiap.brindes.dto.request;

import jakarta.validation.constraints.NotNull;

public record ProdutoRequest(
        @NotNull(message = "Informe o nome do produto")
        String nome,

        @NotNull(message = "Informe o ID da categoria")
        Long categoriaId

) {
}
