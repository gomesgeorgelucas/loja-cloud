package org.letscode.servicovenda.controller;

import lombok.AllArgsConstructor;
import org.letscode.servicovenda.domain.dto.VendaDTO;
import org.letscode.servicovenda.domain.service.VendaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loja-cloud/venda")
@AllArgsConstructor
public class VendaController {
    private final VendaServiceImpl vendaService;

    @GetMapping
    public List<VendaDTO> getAllVendas() {
        return vendaService.getAllVendas();
    }

    @GetMapping("/byVenda/{vendaId}")
    public VendaDTO getVendaByVendaId(@PathVariable Long vendaId)
    {
        return vendaService.getVendaByVendaId(vendaId);
    }

    @PutMapping("/{vendaId}")
    public VendaDTO updateVenda(@PathVariable Long vendaId, @RequestBody VendaDTO vendaDTO)
    {
        return vendaService.updateVenda(vendaId, vendaDTO);
    }

    @PostMapping
    public VendaDTO createVenda(@RequestBody VendaDTO vendaDTO) {
        return vendaService.createVenda(vendaDTO);
    }


    @DeleteMapping("/{vendaId} ")
    public void deleteVenda(@PathVariable Long vendaId) {
        vendaService.deleteVenda(vendaId);
    }

    @GetMapping("/byPessoa/{pessoaId}")
    public List<VendaDTO> getAllVendasByPessoaId(@PathVariable Long pessoaId)
    {
        return getAllVendasByPessoaId(pessoaId);
    }
}
