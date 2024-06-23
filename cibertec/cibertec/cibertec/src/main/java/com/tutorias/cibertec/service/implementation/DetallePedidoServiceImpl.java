package com.tutorias.cibertec.service.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IDetallePedidoDAO;
import com.tutorias.cibertec.persistence.dao.interfaces.IPedidoDAO;
import com.tutorias.cibertec.persistence.dao.interfaces.IProductoDAO;
import com.tutorias.cibertec.persistence.entity.DetallePedidoEntity;
import com.tutorias.cibertec.persistence.entity.PedidoEntity;
import com.tutorias.cibertec.persistence.entity.ProductoEntity;
import com.tutorias.cibertec.presentation.dto.DetallePedidoDTO;
import com.tutorias.cibertec.presentation.dto.PedidoDTO;
import com.tutorias.cibertec.service.interfaces.IDetallePedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetallePedidoServiceImpl implements IDetallePedidoService {

    @Autowired
    private IDetallePedidoDAO detallePedidoDAO;

    @Autowired
    private IPedidoDAO pedidoDAO;

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public List<DetallePedidoDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.detallePedidoDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, DetallePedidoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DetallePedidoDTO findById(Long id) {
        Optional<DetallePedidoEntity> detallePedidoEntity = this.detallePedidoDAO.findById(id);
        if(detallePedidoEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            DetallePedidoEntity currentDetallePedido = detallePedidoEntity.get();
            return modelMapper.map(currentDetallePedido, DetallePedidoDTO.class);
        }else{
            return new DetallePedidoDTO();
        }
    }

    @Override
    public DetallePedidoDTO saveDetallePedido(DetallePedidoDTO detallePedidoDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            DetallePedidoEntity detallePedidoEntity = modelMapper.map(detallePedidoDTO, DetallePedidoEntity.class);

            this.detallePedidoDAO.saveDetallePedido(detallePedidoEntity);
            return detallePedidoDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el detalle del pedido");
        }
    }

    @Override
    public DetallePedidoDTO updateDetallePedido(DetallePedidoDTO detallePedidoDTO, Long id) {
        Optional<DetallePedidoEntity> detallePedidoEntityOptional = this.detallePedidoDAO.findById(id);
        if(detallePedidoEntityOptional.isPresent()){
            DetallePedidoEntity currentDetallePedidoEntity = detallePedidoEntityOptional.get();
            currentDetallePedidoEntity.setCantidad(detallePedidoDTO.getCantidad());
            currentDetallePedidoEntity.setPrecioU(detallePedidoDTO.getPrecioU());

            // Actualiza las relaciones si es necesario
            if (detallePedidoDTO.getIdPedido() != null) {
                Optional<PedidoEntity> pedidoEntityOptional = pedidoDAO.findById(detallePedidoDTO.getIdPedido());
                if (pedidoEntityOptional.isPresent()) {
                    currentDetallePedidoEntity.setIdPedido(pedidoEntityOptional.get());
                } else {
                    throw new IllegalArgumentException("Pedido no encontrado");
                }
            }

            if (detallePedidoDTO.getIdProducto() != null) {
                Optional<ProductoEntity> productoEntityOptional = productoDAO.findById(detallePedidoDTO.getIdProducto());
                if (productoEntityOptional.isPresent()) {
                    currentDetallePedidoEntity.setIdProducto(productoEntityOptional.get());
                } else {
                    throw new IllegalArgumentException("Producto no encontrado");
                }
            }

            this.detallePedidoDAO.updateDetallePedido(currentDetallePedidoEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentDetallePedidoEntity, DetallePedidoDTO.class);
        } else {
            throw new IllegalArgumentException("El detalle del pedido no existe");
        }
    }

    @Override
    public String deleteDetallePedido(Long id) {
        Optional<DetallePedidoEntity> detallePedidoEntity = this.detallePedidoDAO.findById(id);
        if (detallePedidoEntity.isPresent()) {
            DetallePedidoEntity currentDetallePedidoEntity = detallePedidoEntity.get();
            this.detallePedidoDAO.deleteDetallePedido(currentDetallePedidoEntity);
            return "El Detalle del Pedido con ID " + id + " ha sido eliminado";
        } else {
            return "El Detalle del Pedido con ID " + id + " no existe";
        }
    }

    @Override
    public List<DetallePedidoDTO> findByPedido(Long idPedido) {
        Optional<PedidoEntity> pedidoEntity = pedidoDAO.findById(idPedido);
        if (pedidoEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            return this.detallePedidoDAO.findByPedido(pedidoEntity.get())
                    .stream()
                    .map(entity -> modelMapper.map(entity, DetallePedidoDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Pedido no encontrado");
        }
    }

    @Override
    public List<DetallePedidoDTO> findByProducto(Long idProducto) {
        Optional<ProductoEntity> productoEntity = productoDAO.findById(idProducto);
        if (productoEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            return this.detallePedidoDAO.findByProducto(productoEntity.get())
                    .stream()
                    .map(entity -> modelMapper.map(entity, DetallePedidoDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Producto no encontrado");
        }
    }
}
