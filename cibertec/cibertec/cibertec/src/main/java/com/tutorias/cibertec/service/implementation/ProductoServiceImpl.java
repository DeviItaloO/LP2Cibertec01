package com.tutorias.cibertec.service.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IProductoDAO;
import com.tutorias.cibertec.persistence.dao.interfaces.IProveedorDAO;
import com.tutorias.cibertec.persistence.entity.ProductoEntity;
import com.tutorias.cibertec.persistence.entity.ProveedorEntity;
import com.tutorias.cibertec.presentation.dto.ProductoDTO;
import com.tutorias.cibertec.service.interfaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;

    @Autowired
    private IProveedorDAO proveedorDAO;


    @Override
    public List<ProductoDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.productoDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO findById(Long id) {
        Optional<ProductoEntity> productoEntity = this.productoDAO.findById(id);
        if(productoEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            ProductoEntity currentProducto = productoEntity.get();
            return modelMapper.map(currentProducto, ProductoDTO.class);
        }else{
            return new ProductoDTO();
        }
    }

    @Override
    public ProductoDTO saveProducto(ProductoDTO productoDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            ProductoEntity productoEntity = modelMapper.map(productoDTO, ProductoEntity.class);
            this.productoDAO.saveProducto(productoEntity);
            return productoDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el producto");
        }
    }

    @Override
    public ProductoDTO updateProducto(ProductoDTO productoDTO, Long id) {
        Optional<ProductoEntity> productoEntity = this.productoDAO.findById(id);
        if(productoEntity.isPresent()){
            ProductoEntity currentProductoEntity = productoEntity.get();
            currentProductoEntity.setNomProducto(productoDTO.getNomProducto());
            currentProductoEntity.setPrecio(productoDTO.getPrecio());
            currentProductoEntity.setStock(productoDTO.getStock());
            this.productoDAO.updateProducto(currentProductoEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentProductoEntity, ProductoDTO.class);
        }else{
            throw new IllegalArgumentException("El producto no existe");
        }
    }

    @Override
    public String deleteProducto(Long id) {
        Optional<ProductoEntity> productoEntity = this.productoDAO.findById(id);
        if (productoEntity.isPresent()) {
            ProductoEntity currentProductoEntity = productoEntity.get();
            this.productoDAO.deleteProducto(currentProductoEntity);
            return "El Producto con ID " + id + " ha sido eliminado";
        } else {
            return "El Producto con ID " + id + " no existe";
        }
    }

    @Override
    public List<ProductoDTO> findByProveedorId(Long idProveedor) {
        Optional<ProveedorEntity> proveedorEntity = proveedorDAO.findById(idProveedor);
        if (proveedorEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            return this.productoDAO.findByProveedor(proveedorEntity.get())
                    .stream()
                    .map(entity -> modelMapper.map(entity, ProductoDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Proveedor no encontrado");
        }
    }
}
