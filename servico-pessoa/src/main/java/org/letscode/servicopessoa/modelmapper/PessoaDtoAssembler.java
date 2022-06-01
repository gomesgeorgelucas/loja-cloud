package org.letscode.servicopessoa.modelmapper;

import org.letscode.servicopessoa.dto.PessoaDTO;
import org.letscode.servicopessoa.model.PessoaModel;
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

    public PessoaDTO fromModel(PessoaModel pessoaModel) { return modelMapper.map(pessoaModel, PessoaDTO.class); }

    public List<PessoaDTO> fromCollectionModel(List<PessoaModel> pessoas) {
        return pessoas.stream()
                .map(this::fromModel)
                .collect(Collectors.toList());
    }

    public Page<PessoaDTO> fromCollectionModelPage(Page<PessoaModel> page) {
        return page.map(this::fromModel);
    }
}
