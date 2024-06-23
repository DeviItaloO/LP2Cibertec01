package com.tutorias.cibertec.persistence.dao.interfaces;

import com.tutorias.cibertec.persistence.entity.ProductoEntity;
import com.tutorias.cibertec.persistence.entity.ProveedorEntity;

import java.util.List;
import java.util.Optional;

public interface IProductoDAO {
    List<ProductoEntity> findAll();
    Optional<ProductoEntity> findById(Long id);
    void saveProducto(ProductoEntity producto);
    void updateProducto(ProductoEntity producto);
    void deleteProducto(ProductoEntity producto);

    // Buscar productos por proveedor
    List<ProductoEntity> findByProveedor(ProveedorEntity proveedor);
}
