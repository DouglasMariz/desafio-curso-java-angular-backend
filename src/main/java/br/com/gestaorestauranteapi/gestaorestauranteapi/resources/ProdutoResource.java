package br.com.gestaorestauranteapi.gestaorestauranteapi.resources;

import br.com.gestaorestauranteapi.gestaorestauranteapi.model.Produto;
import br.com.gestaorestauranteapi.gestaorestauranteapi.repository.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoResource {

    @Autowired
    private Produtos produtosRepository;

    @PostMapping
    public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto) {
        produtosRepository.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> produtos = produtosRepository.findAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Produto>> getById(@PathVariable Long id) {
        Optional<Produto> produto;
        try {
            produto = produtosRepository.findById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Produto>> deleteById(@PathVariable Long id) {
        try {
            produtosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
