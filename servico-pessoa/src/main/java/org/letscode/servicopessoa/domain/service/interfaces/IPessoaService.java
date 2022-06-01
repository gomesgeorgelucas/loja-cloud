package org.letscode.servicopessoa.domain.service.interfaces;

import org.letscode.servicopessoa.domain.model.PessoaModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPessoaService {

    Mono<PessoaModel> createPessoa(PessoaModel pessoaModel);
    Mono<PessoaModel> readPessoa(Long id);
    Flux<PessoaModel> readAllPessoa();
    Mono<PessoaModel> updatePessoa(Long id, PessoaModel pessoaModel);
    Mono<PessoaModel> deletePessoa(Long id);

}
