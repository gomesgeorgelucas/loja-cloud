package org.letscode.servicoproduto.domain.model;

import lombok.*;
import org.hibernate.annotations.GeneratorType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarrinhoCompra {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idPessoa;

    private Long idProduto;

    private Integer quantidade;

    private Double precoProduto;
}
