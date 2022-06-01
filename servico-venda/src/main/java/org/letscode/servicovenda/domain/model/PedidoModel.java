package org.letscode.servicovenda.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "lc_vendas_pedido")
@Data
public class PedidoModel {
    @Id
    private Long id;

    @Column(value = "id_venda")
    private Long vendaId;

    @Column(value = "id_produto")
    private Long produtoId;

    @Column(value = "quantidade_produto")
    private Long produtoQuantidade;

    @Column(value = "preco_produto")
    private BigDecimal produtoPreco;
}
