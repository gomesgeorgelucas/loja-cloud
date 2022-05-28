package org.letscode.servicoproduto.domain.service;

import org.letscode.servicoproduto.domain.exception.ProdutoNotFoundException;
import org.letscode.servicoproduto.domain.model.Produto;
import org.letscode.servicoproduto.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private static final String MSG_PRODUTO_NAO_ENCOTNADO = "Não existe um cadastro de produto com código %d";

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    @Transactional
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    @Transactional
    public Produto findById(Long id) {
        return BuscarOuFalhar(id);
    }

    @Override
    @Transactional
    public Produto update(Long id, Produto produto) {
        BuscarOuFalhar(id);
        return produtoRepository.save(produto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            produtoRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ProdutoNotFoundException(String.format(MSG_PRODUTO_NAO_ENCOTNADO, id));

        }

    }

    @Override
    @Transactional
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto BuscarOuFalhar(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(String.format(MSG_PRODUTO_NAO_ENCOTNADO, id)));
    }

}
