package com.tutorias.cibertec.service.interfaces;

import com.tutorias.cibertec.presentation.dto.DetallePedidoDTO;

import java.util.List;

public interface IDetallePedidoService {
    List<DetallePedidoDTO> findAll();
    DetallePedidoDTO findById(Long id);
    DetallePedidoDTO saveDetallePedido(DetallePedidoDTO detallePedidoDTO);
    DetallePedidoDTO updateDetallePedido(DetallePedidoDTO detallePedidoDTO, Long id);
    String deleteDetallePedido(Long id);

    List<DetallePedidoDTO> findByPedido(Long idPedido);
    List<DetallePedidoDTO> findByProducto(Long idProducto);
}
