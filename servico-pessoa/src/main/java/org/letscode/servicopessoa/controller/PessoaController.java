package org.letscode.servicopessoa.controller;

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
    public Mono<PessoaModel> createPessoa(@RequestBody PessoaModel pessoaModel) {
        return pessoaService.createPessoa(pessoaModel);
    }

    @GetMapping("/{id}")
    public Mono<PessoaModel> getPessoa(@PathVariable Long id) {
        return pessoaService.readPessoa(id);
    }

    @PutMapping("/{id}")
    public Mono<PessoaModel> updatePessoa(@PathVariable Long id, @RequestBody PessoaModel pessoaModel) {
        return pessoaService.updatePessoa(id, pessoaModel);
    }

    @DeleteMapping("/{id}")
    public Mono<PessoaModel> deletePessoa(@PathVariable Long id) {
        return pessoaService.deletePessoa(id);
    }
}
