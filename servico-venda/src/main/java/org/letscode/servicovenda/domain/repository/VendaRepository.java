package org.letscode.servicovenda.domain.repository;

import org.letscode.servicovenda.domain.model.VendaModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends ReactiveCrudRepository<VendaModel, Long> {
}
