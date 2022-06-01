package org.letscode.servicovenda.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "lc_vendas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendaModel {

    @Id
    @Column(name = "id_venda", nullable = false)
    private Long vendaId;

    @Column(name = "id_pessoa", nullable = false)
    private Long pessoaId;

    @Column(name = "total_venda", nullable = false)
    private BigDecimal vendaTotal;

}
