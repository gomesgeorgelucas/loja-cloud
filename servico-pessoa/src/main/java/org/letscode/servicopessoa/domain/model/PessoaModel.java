package org.letscode.servicopessoa.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "lc_pessoa")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    Long pessoaId;

    @Column(name = "name_pessoa", nullable = false)
    String pessoaName;

    @Column(name = "surname_pessoa", nullable = false)
    String pessoaSurname;

    @Column(name = "login_pessoa", unique = true, nullable = false)
    String pessoaLogin;

    @Column(name = "password_pessoa", nullable = false)
    @ToString.Exclude
    String pessoaPassword;

    @Column(nullable = false)
    @Builder.Default
    private String role = "USER";

    public PessoaModel(@NotNull PessoaModel applicationUser) {
        this.pessoaId = applicationUser.pessoaId;
        this.pessoaLogin = applicationUser.pessoaLogin;
        this.pessoaPassword = applicationUser.pessoaPassword;
        this.role = applicationUser.getRole();
    }
}
