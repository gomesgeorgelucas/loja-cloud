package org.letscode.servicovenda.domain.fetch;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pessoa {
    private Long pessoaId;
    private String pessoaName;
    private String pessoaSurname;
    private String pessoaLogin;
    private String pessoaPassword;
}
