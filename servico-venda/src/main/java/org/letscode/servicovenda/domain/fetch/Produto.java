package org.letscode.servicovenda.domain.fetch;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class Produto {
    private Long id;
    private String nomeProduto;
    private String marca;
    private String descricao;
    private BigDecimal preco;
}
