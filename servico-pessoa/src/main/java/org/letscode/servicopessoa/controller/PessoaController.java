package org.letscode.servicopessoa.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.letscode.servicopessoa.domain.service.PessoaServiceImpl;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("/api/v1/loja-cloud/pessoa")
@RestController
@AllArgsConstructor
public class PessoaController {
    private final PessoaServiceImpl pessoaService;

    @PostMapping
    @CircuitBreaker(name = "servico")
    public Mono<PessoaModel> createPessoa(@RequestBody PessoaModel pessoaModel) {
        return pessoaService.createPessoa(pessoaModel);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "servico")
    public Mono<PessoaModel> getPessoa(@PathVariable Long id) {
        return pessoaService.readPessoa(id);
    }

    @PutMapping("/{id}")
    @CircuitBreaker(name = "servico")
    public Mono<PessoaModel> updatePessoa(@PathVariable Long id, @RequestBody PessoaModel pessoaModel) {
        return pessoaService.updatePessoa(id, pessoaModel);
    }

    @DeleteMapping("/{id}")
    @CircuitBreaker(name = "servico")
    public Mono<PessoaModel> deletePessoa(@PathVariable Long id) {
        return pessoaService.deletePessoa(id);
    }
}
