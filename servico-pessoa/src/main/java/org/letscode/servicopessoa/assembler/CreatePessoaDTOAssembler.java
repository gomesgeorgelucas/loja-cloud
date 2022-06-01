package org.letscode.servicopessoa.assembler;


import lombok.AllArgsConstructor;
import org.letscode.servicopessoa.domain.dto.CreatePessoaDTO;
import org.letscode.servicopessoa.domain.dto.ReadPessoaDTO;
import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePessoaDTOAssembler {
    private final ModelMapper modelMapper;

    public PessoaModel toDomainObject(ReadPessoaDTO pessoaDTO) {
        return modelMapper.map(pessoaDTO, PessoaModel.class);
    }
    public void copyToDomainObject(CreatePessoaDTO pessoaDTO, PessoaModel pessoaModel) {
        modelMapper.map(pessoaDTO, pessoaModel);
    }
}
