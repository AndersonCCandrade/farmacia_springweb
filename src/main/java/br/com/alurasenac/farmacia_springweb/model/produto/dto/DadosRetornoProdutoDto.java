package br.com.alurasenac.farmacia_springweb.model.produto.dto;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;
import br.com.alurasenac.farmacia_springweb.model.produto.Produto;

public record DadosRetornoProdutoDto(
        Integer id,
        String nome,
        String descricao,
        Double preco,
        Fabricante fabricante
) {

    public DadosRetornoProdutoDto(Produto dados) {
        this(dados.getId(), dados.getNome(), dados.getDescricao(), dados.getPreco(), dados.getFabricante());
    }
}

