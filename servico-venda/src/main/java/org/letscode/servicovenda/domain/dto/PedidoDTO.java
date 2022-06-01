package org.letscode.servicovenda.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PedidoDTO {
    private Long vendaId;
    private Long produtoId;
    private Long produtoQuantidade;
    private BigDecimal produtoPreco;
}
