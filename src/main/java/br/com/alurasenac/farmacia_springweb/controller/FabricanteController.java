package br.com.alurasenac.farmacia_springweb.controller;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosAtualizacaoFabricanteDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosRetornoFabricanteDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.DadosRetornoProdutoDto;
import br.com.alurasenac.farmacia_springweb.model.produto.dto.FabricanteDto;
import br.com.alurasenac.farmacia_springweb.model.repository.FabricanteRepositury;
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
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteRepositury fabricanteRepositury;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid FabricanteDto dados, UriComponentsBuilder uriBilder){
        var fabricante = new Fabricante(dados);
        fabricanteRepositury.save(fabricante);

        var uri = uriBilder.path("/medicos/{id}").buildAndExpand(fabricante.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosRetornoFabricanteDto(fabricante));
    }

    @GetMapping
    public ResponseEntity<Page<DadosRetornoFabricanteDto>> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {

        var page = fabricanteRepositury.findAll(paginacao).map(DadosRetornoFabricanteDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoFabricanteDto dados) {
        var fabricante = fabricanteRepositury.getReferenceById(dados.id());

        fabricante.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosRetornoFabricanteDto(fabricante));
    }
}
