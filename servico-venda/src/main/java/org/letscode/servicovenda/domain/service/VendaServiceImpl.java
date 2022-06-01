package org.letscode.servicovenda.domain.service;

import lombok.AllArgsConstructor;
import org.letscode.servicovenda.client.ServicoPessoaClient;
import org.letscode.servicovenda.client.ServicoProdutoClient;
import org.letscode.servicovenda.domain.dto.VendaDTO;
import org.letscode.servicovenda.domain.repository.PedidoRepository;
import org.letscode.servicovenda.domain.repository.VendaRepository;
import org.letscode.servicovenda.domain.service.interfaces.IVendaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class VendaServiceImpl implements IVendaService {
    private final VendaRepository vendaRepository;
    private final PedidoRepository pedidoRepository;

    private final ServicoProdutoClient servicoProdutoClient;
    private final ServicoPessoaClient servicoPessoaClient;

    @Override
    public List<VendaDTO> getAllVendas() {
        return null;
    }

    @Override
    public VendaDTO getVendaByVendaId(Long vendaId) {
        return null;
    }

    @Override
    public VendaDTO createVenda(VendaDTO vendaDTO) {
        return null;
    }

    @Override
    public VendaDTO updateVenda(Long vendaId, VendaDTO vendaDTO) {
        return null;
    }

    @Override
    public void deleteVenda(Long vendaId) {
    }

    @Override
    public List<VendaDTO> getAllVendasByPessoaId(Long pessoaId) {
        return null;
    }
}
