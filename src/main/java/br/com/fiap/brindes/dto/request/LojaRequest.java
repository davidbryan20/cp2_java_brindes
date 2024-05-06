package br.com.fiap.brindes.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LojaRequest(

        @NotBlank(message = "O nome da loja não pode estar em branco")
        String nome

) {
}