package org.letscode.servicopessoa.controller;

import lombok.AllArgsConstructor;
import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.letscode.servicopessoa.domain.service.PessoaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoa")
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

    @GetMapping()
    public List<PessoaModel> getPessoas() {
        return pessoaService.getPessoas();
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
