package br.com.alurasenac.farmacia_springweb.controller;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;
import br.com.alurasenac.farmacia_springweb.model.produto.Produto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosDetalhamentoProduto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.ProdutoDto;
import br.com.alurasenac.farmacia_springweb.model.repository.FabricanteRepositury;
import br.com.alurasenac.farmacia_springweb.model.repository.ProdutoRepositury;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepositury produtoRepositury;
    @Autowired
    private FabricanteRepositury fabricanteRepositury;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ProdutoDto dados, UriComponentsBuilder uriBilder){
        var fabricante = fabricanteRepositury.findByNome(dados.fabricante().nome());
        if(fabricante == null){
            fabricante = new Fabricante(dados.fabricante());
            fabricanteRepositury.save(fabricante);
        }

        var produto = new Produto(dados, fabricante);
        produtoRepositury.save(produto);

        var uri = uriBilder.path("/medicos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }
}
