package org.letscode.servicoproduto.domain.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class ProdutoInput {

    @NotBlank
    private String nomeProduto;

    private String descricao;

    @NotNull
    @PositiveOrZero
    private BigDecimal preco;
}
