package br.com.alurasenac.farmacia_springweb.model.produto.dto;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;

public record DadosRetornoFabricanteDto(
        Integer id,
        String nome
) {
    public DadosRetornoFabricanteDto(Fabricante fabricante) {
        this(fabricante.getId(), fabricante.getNome());
    }
}

