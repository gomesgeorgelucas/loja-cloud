package org.letscode.servicopessoa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ReadPessoaDTO {
    private Long pessoaId;
    private String pessoaName;
    private String pessoaSurname;
    private String pessoaLogin;
    private String pessoaPassword;
}
