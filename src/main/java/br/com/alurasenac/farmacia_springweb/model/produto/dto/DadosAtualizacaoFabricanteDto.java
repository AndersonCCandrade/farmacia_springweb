package br.com.alurasenac.farmacia_springweb.model.produto.dto;
import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFabricanteDto(
        @NotNull
        Integer id,
        String nome
) {
}
