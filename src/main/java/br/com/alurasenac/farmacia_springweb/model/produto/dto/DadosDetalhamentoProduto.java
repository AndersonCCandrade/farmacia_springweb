package br.com.alurasenac.farmacia_springweb.model.produto.dto;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;
import br.com.alurasenac.farmacia_springweb.model.produto.Produto;

public record DadosDetalhamentoProduto(
        Integer id,
        String nome,
        String descricao,
        Double preco,
        Fabricante fabricante
) {

    public DadosDetalhamentoProduto(Produto dados) {
        this(dados.getId(), dados.getNome(), dados.getDescricao(), dados.getPreco(), dados.getFabricante());
    }
}

