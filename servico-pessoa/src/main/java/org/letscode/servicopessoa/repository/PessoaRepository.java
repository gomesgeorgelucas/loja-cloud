package org.letscode.servicopessoa.repository;

import org.letscode.servicopessoa.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
