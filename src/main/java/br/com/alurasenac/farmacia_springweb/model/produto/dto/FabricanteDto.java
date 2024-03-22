package br.com.alurasenac.farmacia_springweb.model.produto.dto;

import jakarta.validation.constraints.NotBlank;

public record FabricanteDto(
        @NotBlank
        String nome
) {
}
