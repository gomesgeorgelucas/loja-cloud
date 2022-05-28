package org.letscode.servicoproduto.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO {

    private Long id;
    private String nomeProduto;
    private String descricao;
    private BigDecimal preco;

}
