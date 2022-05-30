package org.letscode.servicoproduto.domain.repository;

import org.letscode.servicoproduto.domain.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select u from Produto u where upper(trim(u.nomeProduto)) like %?1%")
    Page<Produto> findByNomeProdutoContaining(String nomeProduto, Pageable pageable);
}
