package com.tutorias.cibertec.persistence.dao.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IProductoDAO;
import com.tutorias.cibertec.persistence.entity.ProductoEntity;
import com.tutorias.cibertec.persistence.entity.ProveedorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoDAOImpl implements IProductoDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoEntity> findAll() {
        return this.em.createQuery("SELECT p FROM ProductoEntity p", ProductoEntity.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(ProductoEntity.class, id));
    }

    @Override
    @Transactional
    public void saveProducto(ProductoEntity producto) {
        this.em.persist(producto);
    }

    @Override
    @Transactional
    public void updateProducto(ProductoEntity producto) {
        this.em.merge(producto);
    }

    @Override
    @Transactional
    public void deleteProducto(ProductoEntity producto) {
        if (this.em.contains(producto)) {
            this.em.remove(producto);
        } else {
            this.em.remove(this.em.merge(producto));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoEntity> findByProveedor(ProveedorEntity proveedor) {
        return this.em.createQuery(
                        "SELECT p FROM ProductoEntity p WHERE p.idProveedor = :proveedor", ProductoEntity.class)
                .setParameter("proveedor", proveedor)
                .getResultList();
    }
}
