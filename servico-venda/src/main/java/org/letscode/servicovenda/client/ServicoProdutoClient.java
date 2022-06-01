package org.letscode.servicovenda.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.letscode.servicovenda.domain.fetch.CarrinhoCompra;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="servico-produto")
public interface ServicoProdutoClient {
    @GetMapping("/api/v1/loja-cloud/produto/carrinho/{pessoaId}")
    @CircuitBreaker(name = "servico")
    List<CarrinhoCompra> getCarrinhoByPessoaId(@PathVariable Long pessoaId);
}
