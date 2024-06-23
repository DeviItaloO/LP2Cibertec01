package com.tutorias.cibertec.persistence.dao.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IProveedorDAO;
import com.tutorias.cibertec.persistence.entity.ProveedorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ProveedorDAOImpl implements IProveedorDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorEntity> findAll() {
        return this.em.createQuery("SELECT p FROM ProveedorEntity p").getResultList();
    }

    @Override
    @Transactional
    public Optional<ProveedorEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(ProveedorEntity.class, id));
    }

    @Override
    @Transactional
    public void saveProveedor(ProveedorEntity proveedorEntity) {
        this.em.persist(proveedorEntity);
        this.em.flush();
    }

    @Override
    @Transactional
    public void updateProveedor(ProveedorEntity proveedorEntity) {
        this.em.merge(proveedorEntity);
    }

    @Override
    @Transactional
    public void deleteProveedor(ProveedorEntity proveedorEntity) {
        this.em.remove(proveedorEntity);
    }
}
