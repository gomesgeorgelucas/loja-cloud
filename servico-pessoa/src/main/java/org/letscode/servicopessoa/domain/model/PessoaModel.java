package org.letscode.servicopessoa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "lc_pessoa")
public class PessoaModel {
    @Id
    @Column(value = "id_pessoa")
    private Long pessoaId;

    @Column(value = "name_pessoa")
    private String pessoaName;
    @Column(value = "surname_pessoa")
    private String pessoaSurname;

    @Column(value = "login_pessoa")
    private String pessoaLogin;

    @Column(value = "passwd_pessoa")
    private String pessoaPassword;
}
