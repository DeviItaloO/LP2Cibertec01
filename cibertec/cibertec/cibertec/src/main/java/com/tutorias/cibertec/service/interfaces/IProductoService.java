package com.tutorias.cibertec.service.interfaces;

import com.tutorias.cibertec.presentation.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> findAll();
    ProductoDTO findById(Long id);
    ProductoDTO saveProducto(ProductoDTO producto);
    ProductoDTO updateProducto(ProductoDTO producto, Long id);
    String deleteProducto(Long id);

    // buscar productos por proveedor
    List<ProductoDTO> findByProveedorId(Long idProveedor);
}
