package com.tutorias.cibertec.persistence.dao.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IPedidoDAO;
import com.tutorias.cibertec.persistence.entity.PedidoEntity;
import com.tutorias.cibertec.persistence.entity.PersonaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoDAOImpl implements IPedidoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<PedidoEntity> findAll() {
        return this.em.createQuery("SELECT p FROM PedidoEntity p").getResultList();
    }

    @Override
    @Transactional
    public Optional<PedidoEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(PedidoEntity.class, id));
    }

    @Override
    @Transactional
    public void savePedido(PedidoEntity pedido) {
        this.em.persist(pedido);
        this.em.flush();
    }

    @Override
    @Transactional
    public void updatePedido(PedidoEntity pedido) {
        this.em.merge(pedido);
    }

    @Override
    @Transactional
    public void deletePedido(PedidoEntity pedido) {
        this.em.remove(pedido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoEntity> findByPersona(PersonaEntity persona) {
        return this.em.createQuery("SELECT p FROM PedidoEntity p WHERE p.idPersona = :persona", PedidoEntity.class)
                .setParameter("persona", persona)
                .getResultList();
    }
}
