package br.com.gestaorestauranteapi.gestaorestauranteapi.repository;

import br.com.gestaorestauranteapi.gestaorestauranteapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Long> {
}
