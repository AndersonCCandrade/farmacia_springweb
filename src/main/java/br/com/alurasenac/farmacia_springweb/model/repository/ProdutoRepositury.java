package br.com.alurasenac.farmacia_springweb.model.repository;

import br.com.alurasenac.farmacia_springweb.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositury extends JpaRepository<Produto, Integer> {
}
