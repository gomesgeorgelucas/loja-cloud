package org.letscode.servicoproduto.domain.repository;

import org.letscode.servicopessoa.model.PessoaModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:9080/api/v1/loja-cloud/pessoa", name = "usuario")
public interface PessoaFeingRepository {

    @GetMapping
    List<PessoaModel> buscarTodos();
}
