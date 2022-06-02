package org.letscode.servicovenda.domain.repository;

import org.letscode.servicovenda.domain.model.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<VendaModel, Long> {
    List<VendaModel> findAllByPessoaId(Long pessoaId);
}
