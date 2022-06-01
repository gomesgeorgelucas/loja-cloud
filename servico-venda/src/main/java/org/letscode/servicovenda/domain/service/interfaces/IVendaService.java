package org.letscode.servicovenda.domain.service.interfaces;

import org.letscode.servicovenda.domain.dto.VendaDTO;

import java.util.List;

public interface IVendaService {
    List<VendaDTO> getAllVendas();
    VendaDTO getVendaByVendaId(Long vendaId);

    VendaDTO createVenda(VendaDTO vendaDTO);
    VendaDTO updateVenda(Long vendaId, VendaDTO vendaDTO);
    void deleteVenda(Long vendaId);
    List<VendaDTO> getAllVendasByPessoaId(Long pessoaId);
}
