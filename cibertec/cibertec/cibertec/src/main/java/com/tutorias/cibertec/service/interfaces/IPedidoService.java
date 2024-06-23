package com.tutorias.cibertec.service.interfaces;

import com.tutorias.cibertec.presentation.dto.PedidoDTO;

import java.util.List;

public interface IPedidoService {
    List<PedidoDTO> findAll();
    PedidoDTO findById(Long id);
    PedidoDTO savePedido(PedidoDTO pedido);
    PedidoDTO updatePedido(PedidoDTO pedido, Long id);
    String deletePedido(Long id);

    // buscar pedidos por persona
    List<PedidoDTO> findByPersonaId(Long idPersona);
}
