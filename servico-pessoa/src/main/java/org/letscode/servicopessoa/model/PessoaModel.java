package org.letscode.servicopessoa.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "lc_pessoa")
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

    @Column(name = "passwd_pessoa", nullable = false)
    String pessoaPassword;

    @Column(name = "address_pessoa")
    String pessoaAddress;

}
