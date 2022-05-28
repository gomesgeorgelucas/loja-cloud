package org.letscode.servicoproduto.domain.service.impl;

import lombok.AllArgsConstructor;
import org.letscode.servicoproduto.Assembler.ProdutoDtoAssembler;
import org.letscode.servicoproduto.Assembler.ProdutoInputAssembler;
import org.letscode.servicoproduto.domain.dto.ProdutoDTO;
import org.letscode.servicoproduto.domain.dto.input.ProdutoInput;
import org.letscode.servicoproduto.domain.exception.ProdutoNotFoundException;
import org.letscode.servicoproduto.domain.model.Produto;
import org.letscode.servicoproduto.domain.repository.ProdutoRepository;
import org.letscode.servicoproduto.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private static final String MSG_PRODUTO_NAO_ENCOTNADO = "Não existe um cadastro de produto com código %d";


    private ProdutoRepository produtoRepository;

    private ProdutoDtoAssembler produtoDtoAssembler;

    private ProdutoInputAssembler produtoInputAssembler;


    @Override
    @Transactional
    public List<ProdutoDTO> findAll() {
        return produtoDtoAssembler.toCollectionModel(produtoRepository.findAll());
    }

    @Override
    @Transactional
    public ProdutoDTO findById(Long id) {
        return produtoDtoAssembler.toModel(BuscarOuFalhar(id));
    }

    @Override
    @Transactional
    public ProdutoDTO save(ProdutoInput produtoInput) {
        Produto produto = produtoInputAssembler.toDomainObject(produtoInput);
        return produtoDtoAssembler.toModel(produtoRepository.save(produto));
    }

    @Override
    public Page<ProdutoDTO> findByNomeProdutoContaining(String nomeProduto, Pageable pageable) {
        return produtoDtoAssembler
                .toCollectionModelPage(produtoRepository.findByNomeProdutoContaining(nomeProduto.toUpperCase(), pageable));
    }

    @Override
    public Page<ProdutoDTO> findAllPage(Pageable pageable) {
        Page<Produto> produtosPage = produtoRepository.findAll(pageable);
        List<ProdutoDTO> aeronavesDTO = produtoDtoAssembler.toCollectionModel(produtosPage.getContent());
        Page<ProdutoDTO> aeronavesDtoPage = new PageImpl<>(aeronavesDTO, pageable, produtosPage.getTotalElements());
        return aeronavesDtoPage;
    }

    @Override
    @Transactional
    public ProdutoDTO update(Long id, ProdutoInput produtoInput) {

        Produto produtoAtual = BuscarOuFalhar(id);
        produtoInputAssembler.copyToDomainObject(produtoInput, produtoAtual);
         return produtoDtoAssembler.toModel(produtoRepository.save(produtoAtual));
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

    public Produto BuscarOuFalhar(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(String.format(MSG_PRODUTO_NAO_ENCOTNADO, id)));
    }

}
