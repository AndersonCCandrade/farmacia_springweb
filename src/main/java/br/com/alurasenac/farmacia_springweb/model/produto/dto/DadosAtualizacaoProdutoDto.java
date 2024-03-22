package br.com.alurasenac.farmacia_springweb.model.produto.dto;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProdutoDto (
    @NotNull
    Integer id,
    String nome,
    String descricao,
    Double preco
){

}
