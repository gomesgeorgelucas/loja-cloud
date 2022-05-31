package org.letscode.servicopessoa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "lc_pessoa")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Long pessoaId;

    @Column(name = "name_pessoa", nullable = false)
    private String pessoaName;
    @Column(name = "surname_pessoa", nullable = false)
    private String pessoaSurname;

    @Column(name = "login_pessoa", unique = true, nullable = false)
    private String pessoaLogin;

    @Column(name = "passwd_pessoa", nullable = false)
    private String pessoaPassword;
}
