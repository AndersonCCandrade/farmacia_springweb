package br.com.alurasenac.farmacia_springweb.model.repository;

import br.com.alurasenac.farmacia_springweb.model.produto.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepositury extends JpaRepository<Fabricante, Integer> {

    Fabricante findByNome(String nome);

}
