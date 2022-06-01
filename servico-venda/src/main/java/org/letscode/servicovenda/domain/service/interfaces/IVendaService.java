package org.letscode.servicovenda.domain.service.interfaces;

import org.letscode.servicovenda.domain.model.PedidoModel;
import reactor.core.publisher.Flux;

public interface IVendaService {

    Flux<PedidoModel> getAllPedidos();

    Flux<PedidoModel> getAllPedidosByPessoaId(Long pessoaId);
}
