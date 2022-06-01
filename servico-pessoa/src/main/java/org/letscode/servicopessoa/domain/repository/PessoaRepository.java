package org.letscode.servicopessoa.domain.repository;

import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends ReactiveCrudRepository<PessoaModel, Long> {
    PessoaModel findPessoaModelByPessoaLogin(String username);
}
