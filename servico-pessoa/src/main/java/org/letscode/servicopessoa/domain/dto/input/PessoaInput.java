package org.letscode.servicopessoa.domain.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class PessoaInput {

    @NotBlank
    String pessoaName;

    @NotBlank
    String pessoaSurname;

    @NotBlank
    String pessoaLogin;

    @NotBlank
    String pessoaPassword;
}
