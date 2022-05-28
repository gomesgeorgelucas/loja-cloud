package org.letscode.servicoproduto.domain.service;

import org.letscode.servicoproduto.domain.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();

    Produto findById(Long id);

    Produto update(Long id, Produto produto);

    void delete(Long id);

    Produto save(Produto produto);
}
