package org.letscode.servicopessoa.assembler;


import lombok.AllArgsConstructor;
import org.letscode.servicopessoa.domain.dto.CreatePessoaDTO;
import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ReadPessoaDTOAssembler {
    private final ModelMapper modelMapper;


    public CreatePessoaDTO toModel(PessoaModel pessoa) {
        return modelMapper.map(pessoa, CreatePessoaDTO.class);
    }
    public List<CreatePessoaDTO> toCollectionModel(List<PessoaModel> pessoas) {
        return pessoas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
    public Page<CreatePessoaDTO> toCollectionModelPage(Page<PessoaModel> page) {
        return page.map(pessoa -> toModel(pessoa));
    }
}
