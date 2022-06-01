package org.letscode.servicovenda.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VendaDTO {
    private Long vendaId;
    private Long pessoaId;

    List<PedidoDTO> carrinhoCompras;

}
