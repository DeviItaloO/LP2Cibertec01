package com.tutorias.cibertec.persistence.dao.interfaces;

import com.tutorias.cibertec.persistence.entity.ProveedorEntity;
import java.util.List;
import java.util.Optional;

public interface IProveedorDAO {
    List<ProveedorEntity> findAll();
    Optional<ProveedorEntity> findById(Long id);
    void saveProveedor(ProveedorEntity proveedor);
    void updateProveedor(ProveedorEntity proveedor);
    void deleteProveedor(ProveedorEntity proveedor);
}
