package org.letscode.servicovenda.domain.fetch;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CarrinhoCompra {
    private Long id;
    private Long idPessoa;
    private Long idProduto;
    private Integer quantidade;
    private BigDecimal precoUnitario;
}
