package com.tutorias.cibertec.persistence.dao.interfaces;

import com.tutorias.cibertec.persistence.entity.PedidoEntity;
import com.tutorias.cibertec.persistence.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface IPedidoDAO {
    List<PedidoEntity> findAll();
    Optional<PedidoEntity> findById(Long id);
    void savePedido(PedidoEntity pedido);
    void updatePedido(PedidoEntity pedido);
    void deletePedido(PedidoEntity pedido);

    // BUSCA PERSONAS POR PEDIDO
    List<PedidoEntity> findByPersona(PersonaEntity persona);
}
