package org.letscode.servicopessoa.Assembler;

import org.letscode.servicopessoa.domain.dto.PessoaDTO;
import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;


    public PessoaDTO toModel(PessoaModel pessoa) {
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> toCollectionModel(List<PessoaModel> Pessoas) {
        return Pessoas.stream()
                .map(produto -> toModel(produto))
                .collect(Collectors.toList());
    }

    public Page<PessoaDTO> toCollectionModelPage(Page<PessoaModel> page) {
        return page.map(pessoa -> toModel(pessoa));
    }
}
