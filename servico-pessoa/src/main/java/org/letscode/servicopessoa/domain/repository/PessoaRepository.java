package org.letscode.servicopessoa.domain.repository;

import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PessoaRepository extends ReactiveCrudRepository<PessoaModel, Long> {
}
