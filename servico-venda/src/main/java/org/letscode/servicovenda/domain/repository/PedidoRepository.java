package org.letscode.servicovenda.domain.repository;

import org.letscode.servicovenda.domain.model.PedidoModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface PedidoRepository extends ReactiveCrudRepository<PedidoModel, Long> {
    Flux<PedidoModel> findPedidoModelByPessoaId(Long pessoaId);
}
