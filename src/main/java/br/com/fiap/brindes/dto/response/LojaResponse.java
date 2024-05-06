package br.com.fiap.brindes.dto.response;

import lombok.Builder;

@Builder
public record LojaResponse(
        Long id,
        String nome
) {}