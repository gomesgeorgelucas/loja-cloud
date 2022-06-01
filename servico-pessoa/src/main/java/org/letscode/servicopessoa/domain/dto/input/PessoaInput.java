package org.letscode.servicopessoa.domain.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

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
