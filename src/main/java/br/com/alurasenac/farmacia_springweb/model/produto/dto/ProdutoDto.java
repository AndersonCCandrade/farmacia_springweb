package br.com.alurasenac.farmacia_springweb.model.produto.dto;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Double preco,
        @NotNull
        @Valid
        FabricanteDto fabricante) {
}
