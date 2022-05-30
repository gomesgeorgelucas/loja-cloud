package org.letscode.servicoproduto.Assembler;

import org.letscode.servicoproduto.domain.dto.input.ProdutoInput;
import org.letscode.servicoproduto.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoInputAssembler {

    @Autowired
    private ModelMapper modelMapper;


    public Produto toDomainObject(ProdutoInput produtoInput) {
        return modelMapper.map(produtoInput, Produto.class);
    }

    public void copyToDomainObject(ProdutoInput produtoInput, Produto produto) {
        modelMapper.map(produtoInput, produto);
    }
}
