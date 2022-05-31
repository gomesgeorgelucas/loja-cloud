package org.letscode.servicoproduto.controller;

import org.letscode.servicopessoa.model.PessoaModel;
import org.letscode.servicoproduto.domain.dto.ProdutoDTO;
import org.letscode.servicoproduto.domain.dto.input.ProdutoInput;
import org.letscode.servicoproduto.domain.model.Produto;
import org.letscode.servicoproduto.domain.repository.PessoaFeingRepository;
import org.letscode.servicoproduto.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PessoaFeingRepository pessoaFeingRepository;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<ProdutoDTO>> listarProdutosPage(
            @PageableDefault(size = 5, sort = "nomeProduto") Pageable pageable) {
        return ResponseEntity.ok(produtoService.findAllPage(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @GetMapping("/find/{nomeProduto}/paging")
    public ResponseEntity<Page<ProdutoDTO>> findModeloPage(@PathVariable String nomeProduto,
                                                            @PageableDefault(size = 5, sort = "nomeProduto") Pageable pageable) {
        return ResponseEntity.ok(produtoService.findByNomeProdutoContaining(nomeProduto, pageable));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> saveAeronave(@RequestBody @Valid ProdutoInput produtoInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateAeronave(@PathVariable Long id,
                                                  @RequestBody @Valid ProdutoInput produtoInput) {
        return ResponseEntity.ok(produtoService.update(id, produtoInput));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable  Long id) {
        produtoService.delete(id);
    }

    @GetMapping("teste")
    public ResponseEntity<List<PessoaModel>> teste(){
        return ResponseEntity.ok(pessoaFeingRepository.buscarTodos());
    }

}
