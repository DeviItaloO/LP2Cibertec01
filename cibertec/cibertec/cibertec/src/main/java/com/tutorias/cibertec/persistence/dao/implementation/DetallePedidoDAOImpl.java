package com.tutorias.cibertec.persistence.dao.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IDetallePedidoDAO;
import com.tutorias.cibertec.persistence.entity.DetallePedidoEntity;
import com.tutorias.cibertec.persistence.entity.PedidoEntity;
import com.tutorias.cibertec.persistence.entity.ProductoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class DetallePedidoDAOImpl implements IDetallePedidoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<DetallePedidoEntity> findAll() {
        return em.createQuery("SELECT dp FROM DetallePedidoEntity dp").getResultList();
    }

    @Override
    @Transactional
    public Optional<DetallePedidoEntity> findById(Long id) {
        return Optional.ofNullable(em.find(DetallePedidoEntity.class, id));
    }

    @Override
    @Transactional
    public void saveDetallePedido(DetallePedidoEntity detallePedido) {
        this.em.persist(detallePedido);
        this.em.flush();
    }

    @Override
    @Transactional
    public void updateDetallePedido(DetallePedidoEntity detallePedido) {
        this.em.merge(detallePedido);
    }

    @Override
    @Transactional
    public void deleteDetallePedido(DetallePedidoEntity detallePedido) {
        this.em.remove(detallePedido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetallePedidoEntity> findByPedido(PedidoEntity pedido) {
        return em.createQuery("SELECT dp FROM DetallePedidoEntity dp WHERE dp.idPedido = :pedido", DetallePedidoEntity.class)
                .setParameter("pedido", pedido)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetallePedidoEntity> findByProducto(ProductoEntity producto) {
        return em.createQuery("SELECT dp FROM DetallePedidoEntity dp WHERE dp.idProducto = :producto", DetallePedidoEntity.class)
                .setParameter("producto", producto)
                .getResultList();
    }
}
