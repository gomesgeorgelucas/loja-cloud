package org.letscode.servicopessoa.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PessoaInput {

    @NotBlank
    String pessoaName;
    String pessoaSurname;

    @NotBlank
    String pessoaLogin;
    @NotBlank
    String pessoaPassword;

    String pessoaAddress;
}
