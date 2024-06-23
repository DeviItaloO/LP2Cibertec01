package com.tutorias.cibertec.persistence.dao.interfaces;

import com.tutorias.cibertec.persistence.entity.DetallePedidoEntity;
import com.tutorias.cibertec.persistence.entity.PedidoEntity;
import com.tutorias.cibertec.persistence.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface IDetallePedidoDAO {
    List<DetallePedidoEntity> findAll();
    Optional<DetallePedidoEntity> findById(Long id);
    void saveDetallePedido(DetallePedidoEntity detallePedido);
    void updateDetallePedido(DetallePedidoEntity detallePedido);
    void deleteDetallePedido(DetallePedidoEntity detallePedido);

    List<DetallePedidoEntity> findByPedido(PedidoEntity pedido);
    List<DetallePedidoEntity> findByProducto(ProductoEntity producto);
}
