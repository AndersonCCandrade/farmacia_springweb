package br.com.alurasenac.farmacia_springweb.controller;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;
import br.com.alurasenac.farmacia_springweb.model.produto.Produto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosAtualizacaoFabricanteDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosAtualizacaoProdutoDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosRetornoProdutoDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.ProdutoDto;
import br.com.alurasenac.farmacia_springweb.model.repository.FabricanteRepositury;
import br.com.alurasenac.farmacia_springweb.model.repository.ProdutoRepositury;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

        return ResponseEntity.created(uri).body(new DadosRetornoProdutoDto(produto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosRetornoProdutoDto>> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {

        var page =  produtoRepositury.findAll(paginacao).map(DadosRetornoProdutoDto::new);

        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProdutoDto dados) {
        var Produto = produtoRepositury.getReferenceById(dados.id());
        Produto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosRetornoProdutoDto(Produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Integer id) {

       produtoRepositury.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
