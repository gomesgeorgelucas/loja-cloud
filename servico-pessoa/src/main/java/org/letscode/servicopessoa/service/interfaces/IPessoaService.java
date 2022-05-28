package org.letscode.servicopessoa.service.interfaces;

import org.letscode.servicopessoa.model.PessoaModel;

public interface IPessoaService {
    PessoaModel createPessoa(PessoaModel pessoaModel);
    PessoaModel readPessoa(Long id);
    PessoaModel updatePessoa(Long id, PessoaModel pessoaModel);
    void deletePessoa(Long id);

}
