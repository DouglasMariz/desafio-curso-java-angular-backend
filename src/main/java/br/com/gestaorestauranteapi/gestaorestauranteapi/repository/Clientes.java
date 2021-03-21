package br.com.gestaorestauranteapi.gestaorestauranteapi.repository;

import br.com.gestaorestauranteapi.gestaorestauranteapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clientes extends JpaRepository<Cliente, Long> {
}
