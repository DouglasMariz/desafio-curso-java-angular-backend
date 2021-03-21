package br.com.gestaorestauranteapi.gestaorestauranteapi.repository;

import br.com.gestaorestauranteapi.gestaorestauranteapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Long> {
}
