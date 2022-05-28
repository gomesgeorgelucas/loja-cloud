package org.letscode.servicoproduto.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Table
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nomeProduto;

    private String descricao;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private BigDecimal preco;

}
