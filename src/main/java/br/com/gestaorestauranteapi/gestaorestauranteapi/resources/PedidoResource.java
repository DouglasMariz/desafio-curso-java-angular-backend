package br.com.gestaorestauranteapi.gestaorestauranteapi.resources;

import br.com.gestaorestauranteapi.gestaorestauranteapi.model.Pedido;
import br.com.gestaorestauranteapi.gestaorestauranteapi.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/pedidos")
public class PedidoResource {

    @Autowired
    private Pedidos pedidosRepository;

    @PostMapping
    public ResponseEntity<Pedido> save(@Valid @RequestBody Pedido pedido) {
        pedidosRepository.save(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll() {
        List<Pedido> pedidos = pedidosRepository.findAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Pedido>> getById(@PathVariable Long id) {
        Optional<Pedido> pedido;
        try {
            pedido = pedidosRepository.findById(id);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Pedido>> deleteById(@PathVariable Long id) {
        try {
            pedidosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
