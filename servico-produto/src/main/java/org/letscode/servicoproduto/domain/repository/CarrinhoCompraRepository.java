package org.letscode.servicoproduto.domain.repository;

import org.letscode.servicoproduto.domain.model.CarrinhoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
}
