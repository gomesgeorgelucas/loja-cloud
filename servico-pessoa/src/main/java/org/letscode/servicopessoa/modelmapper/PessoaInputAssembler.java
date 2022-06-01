package org.letscode.servicopessoa.modelmapper;

import org.letscode.servicopessoa.dto.PessoaDTO;
import org.letscode.servicopessoa.dto.input.PessoaInput;
import org.letscode.servicopessoa.model.PessoaModel;
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

    public void copyToDomainObject(PessoaInput pessoaInput, PessoaModel pessoaModel) {
        modelMapper.map(pessoaInput, pessoaModel);
    }
}
