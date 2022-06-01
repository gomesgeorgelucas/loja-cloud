package org.letscode.servicovenda.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "lc_vendas_pedido")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_venda")
    private Long vendaId;

    @Column(name = "id_produto")
    private Long produtoId;

    @Column(name = "quantidade_produto")
    private Long produtoQuantidade;

    @Column(name = "preco_produto")
    private BigDecimal produtoPreco;
}
