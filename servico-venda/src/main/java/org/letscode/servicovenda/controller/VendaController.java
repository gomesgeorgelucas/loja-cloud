package org.letscode.servicovenda.controller;

import lombok.AllArgsConstructor;
import org.letscode.servicovenda.domain.model.PedidoModel;
import org.letscode.servicovenda.domain.service.VendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/v1/loja-cloud/venda")
@AllArgsConstructor
public class VendaController {
    @Autowired
    private final VendaServiceImpl vendaService;

    @GetMapping
    public Flux<PedidoModel> getAllPedidos() {
        return vendaService.getAllPedidos();
    }

    @GetMapping("/{pessoaId}")
    public Flux<PedidoModel> getAllPedidosByPessoaId(@PathVariable Long pessoaId) {
        return vendaService.getAllPedidosByPessoaId(pessoaId);
    }
}
