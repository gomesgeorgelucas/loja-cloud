package org.letscode.servicoproduto.Assembler;

import org.letscode.servicoproduto.domain.dto.ProdutoDTO;
import org.letscode.servicoproduto.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;


    public ProdutoDTO toModel(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> toCollectionModel(List<Produto> Produtos) {
        return Produtos.stream()
                .map(produto -> toModel(produto))
                .collect(Collectors.toList());
    }

    public Page<ProdutoDTO> toCollectionModelPage(Page<Produto> page) {
        return page.map(produto -> toModel(produto));
    }
}
