package org.letscode.servicopessoa.domain.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.letscode.servicopessoa.domain.repository.PessoaRepository;
import org.letscode.servicopessoa.domain.service.interfaces.IPessoaService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements IPessoaService {

    private final PessoaRepository pessoaRepository;

    @Override
    public Mono<PessoaModel> createPessoa(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }

    @Override
    public Flux<PessoaModel> readAllPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public Mono<PessoaModel> readPessoa(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Mono<PessoaModel> updatePessoa(Long id, PessoaModel pessoaModel) {
        return pessoaRepository.findById(id).flatMap(pessoaToUpdate -> {
            pessoaToUpdate.setPessoaName(pessoaModel.getPessoaName());
            pessoaToUpdate.setPessoaSurname(pessoaModel.getPessoaSurname());
            pessoaToUpdate.setPessoaLogin(pessoaModel.getPessoaLogin());
            pessoaToUpdate.setPessoaPassword(pessoaModel.getPessoaPassword());
            return pessoaRepository.save(pessoaToUpdate);
        });
    }

    @Override
    public Mono<PessoaModel> deletePessoa(Long id) {
        return pessoaRepository.findById(id)
                .flatMap(usuarioEncontrado ->
                        pessoaRepository.delete(usuarioEncontrado)
                                .then(Mono.just(usuarioEncontrado)));
    }
}
