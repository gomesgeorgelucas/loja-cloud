package org.letscode.servicopessoa.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PessoaDTO {
    Long pessoaId;
    String pessoaName;
    String pessoaSurname;
    String pessoaLogin;
    String pessoaPassword;
    String pessoaAddress;
}
