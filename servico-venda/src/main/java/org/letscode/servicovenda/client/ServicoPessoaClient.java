package org.letscode.servicovenda.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.letscode.servicovenda.domain.fetch.Pessoa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="servico-pessoa")
public interface ServicoPessoaClient {
    @GetMapping("/api/v1/loja-lets/pessoa/{pessoaId}")
    @CircuitBreaker(name = "servico")
    Pessoa getPessoaById(@PathVariable Long pessoaId);
}
