package br.com.gestaorestauranteapi.gestaorestauranteapi.resources;

import br.com.gestaorestauranteapi.gestaorestauranteapi.model.Cliente;
import br.com.gestaorestauranteapi.gestaorestauranteapi.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteResource {

    @Autowired
    private Clientes clientesRepository;

    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        clientesRepository.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clientesRepository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Cliente>> getById(@PathVariable Long id) {
        Optional<Cliente> cliente;
        try {
            cliente = clientesRepository.findById(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Cliente>> deleteById(@PathVariable Long id) {
        try {
            clientesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
