package org.letscode.servicovenda.domain.repository;

import org.letscode.servicovenda.domain.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
    List<PedidoModel> findAllByVendaId(Long vendaId);
}
