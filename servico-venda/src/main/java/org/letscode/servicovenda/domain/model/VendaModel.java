package org.letscode.servicovenda.domain.model;

import lombok.*;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "lc_vendas")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class VendaModel {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long vendaId;

    @Column(name = "id_pessoa")
    private Long pessoaId;

    @Column(name = "total_venda")
    private BigDecimal vendaTotal;

}
