package org.letscode.servicovenda.domain.service;

import lombok.AllArgsConstructor;
import org.letscode.servicovenda.domain.model.PedidoModel;
import org.letscode.servicovenda.domain.repository.PedidoRepository;
import org.letscode.servicovenda.domain.repository.VendaRepository;
import org.letscode.servicovenda.domain.service.interfaces.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class VendaServiceImpl implements IVendaService {
    @Autowired
    private final VendaRepository vendaRepository;
    @Autowired
    private final PedidoRepository pedidoRepository;


    @Override
    public Flux<PedidoModel> getAllPedidosByPessoaId(Long pessoaId) {
        return pedidoRepository.findPedidoModelByPessoaId(pessoaId);
    }

    @Override
    public Flux<PedidoModel> getAllPedidos() {
        return pedidoRepository.findAll();
    }
}
