package org.letscode.servicoproduto.domain.service;

import org.letscode.servicoproduto.domain.dto.ProdutoDTO;
import org.letscode.servicoproduto.domain.dto.input.ProdutoInput;
import org.letscode.servicoproduto.domain.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {

    List<ProdutoDTO> findAll();

    ProdutoDTO findById(Long id);

    ProdutoDTO update(Long id, ProdutoInput produtoInput);

    void delete(Long id);

    ProdutoDTO save(ProdutoInput produtoInput);

    Page<ProdutoDTO> findByNomeProdutoContaining(String nomeProduto, Pageable pageable);

    Page<ProdutoDTO> findAllPage(Pageable pageable);
}
