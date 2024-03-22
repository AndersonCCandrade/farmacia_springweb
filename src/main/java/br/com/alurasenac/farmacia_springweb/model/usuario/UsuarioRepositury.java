package br.com.alurasenac.farmacia_springweb.model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositury extends JpaRepository<Usuario, Integer> {
    UserDetails findByLogin(String login);
}
