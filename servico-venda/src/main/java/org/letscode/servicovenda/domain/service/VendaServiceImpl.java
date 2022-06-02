package org.letscode.servicovenda.domain.service;

import lombok.AllArgsConstructor;
import org.letscode.servicovenda.client.ServicoPessoaClient;
import org.letscode.servicovenda.client.ServicoProdutoClient;
import org.letscode.servicovenda.domain.dto.PedidoDTO;
import org.letscode.servicovenda.domain.dto.VendaDTO;
import org.letscode.servicovenda.domain.model.PedidoModel;
import org.letscode.servicovenda.domain.model.VendaModel;
import org.letscode.servicovenda.domain.repository.PedidoRepository;
import org.letscode.servicovenda.domain.repository.VendaRepository;
import org.letscode.servicovenda.domain.service.interfaces.IVendaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public List<VendaDTO> getAllVendas()
    {
        List<VendaDTO> vendasDTO = new ArrayList<>();
        List<VendaModel> vendas = vendaRepository.findAll();
        for (VendaModel venda: vendas ) {
            vendasDTO.add(VendaDTO.builder()
                    .pessoaId(venda.getPessoaId())
                    .vendaId(venda.getVendaId())
                    .carrinhoCompras(pedidoRepository.findAllByVendaId(venda.getVendaId()))
                    .build());
        }

        return vendasDTO;
    }

    @Override
    public VendaDTO getVendaByVendaId(Long vendaId)
    {
        VendaModel vendaModel = vendaRepository.getById(vendaId);
        return VendaDTO.builder()
                .vendaId(vendaModel.getVendaId())
                .pessoaId(vendaModel.getPessoaId())
                .carrinhoCompras(pedidoRepository.findAllByVendaId(vendaModel.getVendaId()))
                .build();
    }

    @Override
    public List<VendaDTO> getAllVendasByPessoaId(Long pessoaId) {
        List<VendaDTO> vendasDTO = new ArrayList<>();
        List<VendaModel> vendasModel = vendaRepository.findAllByPessoaId(pessoaId);
        for (VendaModel venda: vendasModel) {
            vendasDTO.add(VendaDTO.builder()
                    .pessoaId(venda.getPessoaId())
                    .vendaId(venda.getVendaId())
                    .carrinhoCompras(pedidoRepository.findAllByVendaId(venda.getVendaId()))
                    .build());
        }

        return vendasDTO;
    }

    @Override
    public VendaDTO createVenda(VendaDTO vendaDTO) {
        VendaModel venda = VendaModel.builder()
                .pessoaId(vendaDTO.getPessoaId())
                .vendaTotal(calculateTotal(vendaDTO))
                .build();

        venda.setVendaId(vendaRepository.save(venda).getVendaId());

        for (PedidoModel pedido :
                vendaDTO.getCarrinhoCompras()) {
            pedido.setVendaId(venda.getVendaId());
            pedidoRepository.save(pedido);
        }

        return VendaDTO.builder()
                .pessoaId(venda.getPessoaId())
                .vendaId(venda.getVendaId())
                .carrinhoCompras(vendaDTO.getCarrinhoCompras())
                .build();
    }

    private BigDecimal calculateTotal(VendaDTO vendaDTO) {
        BigDecimal sum = BigDecimal.valueOf(0);

        for (PedidoModel pedido :
                vendaDTO.getCarrinhoCompras()) {
            sum.add(pedido.getProdutoPreco().multiply(BigDecimal.valueOf(pedido.getProdutoQuantidade())));
        }

        return sum;
    }

    @Override
    public VendaDTO updateVenda(Long vendaId, VendaDTO vendaDTO) {
        return null;
    }

    @Override
    @Transactional
    public void deleteVenda(Long vendaId) {
        List<PedidoModel> pedidos = pedidoRepository.findAllByVendaId(vendaId);
        for (PedidoModel pedido : pedidos) {
            pedidoRepository.delete(pedido);
        }
        vendaRepository.deleteById(vendaId);
    }


}
