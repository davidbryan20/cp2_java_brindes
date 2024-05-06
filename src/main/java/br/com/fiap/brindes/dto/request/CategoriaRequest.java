package br.com.fiap.brindes.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(

        @NotBlank(message = "O nome da categoria não pode estar em branco")
        String nome

) {
}