package com.tutorias.cibertec.service.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IPedidoDAO;
import com.tutorias.cibertec.persistence.dao.interfaces.IPersonaDAO;
import com.tutorias.cibertec.persistence.entity.PedidoEntity;
import com.tutorias.cibertec.persistence.entity.PersonaEntity;
import com.tutorias.cibertec.presentation.dto.PedidoDTO;
import com.tutorias.cibertec.service.interfaces.IPedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoDAO pedidoDAO;

    @Autowired
    private IPersonaDAO personaDAO;

    @Override
    public List<PedidoDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.pedidoDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, PedidoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO findById(Long id) {
        Optional<PedidoEntity> pedidoEntity = this.pedidoDAO.findById(id);
        if(pedidoEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            PedidoEntity currentPedido = pedidoEntity.get();
            return modelMapper.map(currentPedido, PedidoDTO.class);
        }else{
            return new PedidoDTO();
        }
    }

    @Override
    public PedidoDTO savePedido(PedidoDTO pedidoDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            PedidoEntity pedidoEntity = modelMapper.map(pedidoDTO, PedidoEntity.class);

            this.pedidoDAO.savePedido(pedidoEntity);
            return pedidoDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el pedido");
        }
    }

    @Override
    public PedidoDTO updatePedido(PedidoDTO pedidoDTO, Long id) {
        Optional<PedidoEntity> pedidoEntity = this.pedidoDAO.findById(id);
        if(pedidoEntity.isPresent()){
            PedidoEntity currentPedidoEntity = pedidoEntity.get();
            currentPedidoEntity.setFechaPedido(pedidoDTO.getFechaPedido());
            currentPedidoEntity.setTotalPedido(pedidoDTO.getTotalPedido());
            this.pedidoDAO.updatePedido(currentPedidoEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentPedidoEntity, PedidoDTO.class);
        }else{
            throw new IllegalArgumentException("El pedido no existe");
        }
    }

    @Override
    public String deletePedido(Long id) {
        Optional<PedidoEntity> pedidoEntity = this.pedidoDAO.findById(id);
        if (pedidoEntity.isPresent()) {
            PedidoEntity currentPedidoEntity = pedidoEntity.get();
            this.pedidoDAO.deletePedido(currentPedidoEntity);
            return "El Pedido con ID " + id + " ha sido eliminado";
        } else {
            return "El Pedido con ID " + id + " no existe";
        }
    }

    @Override
    public List<PedidoDTO> findByPersonaId(Long idPersona) {
        Optional<PersonaEntity> personaEntity = personaDAO.findById(idPersona);
        if (personaEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            return this.pedidoDAO.findByPersona(personaEntity.get())
                    .stream()
                    .map(entity -> modelMapper.map(entity, PedidoDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Persona no encontrada");
        }
    }
}
