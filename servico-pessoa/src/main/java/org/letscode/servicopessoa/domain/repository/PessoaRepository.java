package org.letscode.servicopessoa.domain.repository;

import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
