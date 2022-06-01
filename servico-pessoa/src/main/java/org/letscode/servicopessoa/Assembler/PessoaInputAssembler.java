package org.letscode.servicopessoa.Assembler;

import org.letscode.servicopessoa.domain.dto.input.PessoaInput;
import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaInputAssembler {

    @Autowired
    private ModelMapper modelMapper;


    public PessoaModel toDomainObject(PessoaInput pessoaInput) {
        return modelMapper.map(pessoaInput, PessoaModel.class);
    }

    public void copyToDomainObject(PessoaInput pessoaInput, PessoaModel pessoa) {
        modelMapper.map(pessoaInput, pessoa);
    }
}
