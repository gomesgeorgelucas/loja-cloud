package org.letscode.servicopessoa.service;

import lombok.AllArgsConstructor;
import org.letscode.servicopessoa.model.PessoaModel;
import org.letscode.servicopessoa.repository.PessoaRepository;
import org.letscode.servicopessoa.service.interfaces.IPessoaService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements IPessoaService {

    private PessoaRepository pessoaRepository;

    @Override
    public PessoaModel createPessoa(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }

    @Override
    public PessoaModel readPessoa(Long id) {
        return pessoaRepository.findById(id).get();
    }

    @Override
    public PessoaModel updatePessoa(Long id, PessoaModel pessoaModel) {
        PessoaModel toUpdate = readPessoa(id);
        toUpdate.setPessoaName(pessoaModel.getPessoaName());
        toUpdate.setPessoaSurname(pessoaModel.getPessoaSurname());
        toUpdate.setPessoaLogin(pessoaModel.getPessoaLogin());
        toUpdate.setPessoaPassword(pessoaModel.getPessoaPassword());

        return pessoaRepository.save(toUpdate);
    }

    @Override
    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
