package com.tutorias.cibertec.service.interfaces;

import com.tutorias.cibertec.presentation.dto.ProveedorDTO;

import java.util.List;

public interface IProveedorService {

    //LISTAR TODOS
    List<ProveedorDTO> findAll();
    //buscar por id
    ProveedorDTO findById(Long id);
    //GRABAR NUEVO
    ProveedorDTO saveProveedor(ProveedorDTO proveedor);
    //Actualizar
    ProveedorDTO updateProveedor(ProveedorDTO proveedor, Long id);
    //Eliminar
    String deleteProveedor(Long id);

}
