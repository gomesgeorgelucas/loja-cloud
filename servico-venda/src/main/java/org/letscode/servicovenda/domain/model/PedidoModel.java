package org.letscode.servicovenda.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "lc_vendas_pedido")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModel {
    @Id
    @Column(name = "id_pedido", nullable = false)
    private Long pedidoId;

    @Column(name = "id_venda", nullable = false)
    private Long vendaId;

    @Column(name = "id_produto", nullable = false)
    private Long produtoId;

    @Column(name = "quantidade_produto", nullable = false)
    private Long produtoQuantidade;

    @Column(name = "preco_produto", nullable = false)
    private BigDecimal produtoPreco;
}

