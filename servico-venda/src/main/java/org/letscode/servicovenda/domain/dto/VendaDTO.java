package org.letscode.servicovenda.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.letscode.servicovenda.domain.model.PedidoModel;

import java.util.List;

@Data
@Builder
public class VendaDTO {
    private Long vendaId;
    private Long pessoaId;

    List<PedidoModel> carrinhoCompras;

}
