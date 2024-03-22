package br.com.alurasenac.farmacia_springweb.model.produto;

import br.com.alurasenac.farmacia_springweb.controller.FabricanteController;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosAtualizacaoFabricanteDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosAtualizacaoProdutoDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.ProdutoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Produto")
@Table(name = "produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private Double preco;
    @ManyToOne
    private Fabricante fabricante;
    public Produto(ProdutoDto dados, Fabricante fabricante) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.fabricante = fabricante;
    }

    public void atualizarInformacoes(DadosAtualizacaoProdutoDto dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.preco() != null) {
            this.preco=(dados.preco());
        }

    }

}
