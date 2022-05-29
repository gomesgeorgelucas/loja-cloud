package org.letscode.servicopessoa.controller;

import lombok.AllArgsConstructor;
import org.letscode.servicopessoa.model.PessoaModel;
import org.letscode.servicopessoa.service.PessoaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/loja-cloud/pessoa")
@RestController
@AllArgsConstructor
public class PessoaController {
    private PessoaServiceImpl pessoaService;

    @PostMapping
    public PessoaModel createPessoa(@RequestBody PessoaModel pessoaModel) {
        return pessoaService.createPessoa(pessoaModel);
    }

    @GetMapping("/{id}")
    public PessoaModel getPessoa(@PathVariable Long id) {
        return pessoaService.readPessoa(id);
    }

    @PutMapping("/{id}")
    public PessoaModel updatePessoa(@PathVariable Long id, @RequestBody PessoaModel pessoaModel) {
        return pessoaService.updatePessoa(id, pessoaModel);
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
    }
}
