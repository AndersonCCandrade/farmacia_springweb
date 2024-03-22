package br.com.alurasenac.farmacia_springweb.model.produto.dto;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;

public record DadosDetalhamentoFabricante(
        Integer id,
        String nome
) {
    public DadosDetalhamentoFabricante(Fabricante fabricante) {
        this(fabricante.getId(), fabricante.getNome());
    }
}

