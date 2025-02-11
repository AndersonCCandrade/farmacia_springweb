package br.com.alurasenac.farmacia_springweb.model.produto;

import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosAtualizacaoFabricanteDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.FabricanteDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Fabricante")
@Table(name = "fabricantes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;


    public Fabricante(FabricanteDto dados) {
        this.nome= dados.nome();
    }

    public void atualizarInformacoes(DadosAtualizacaoFabricanteDto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

}
