package com.tutorias.cibertec.service.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IProveedorDAO;
import com.tutorias.cibertec.persistence.entity.ProveedorEntity;
import com.tutorias.cibertec.presentation.dto.ProveedorDTO;
import com.tutorias.cibertec.service.interfaces.IProveedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements IProveedorService {
    @Autowired
    private IProveedorDAO proveedorDAO;

    @Override
    public List<ProveedorDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.proveedorDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ProveedorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProveedorDTO findById(Long id) {
        Optional<ProveedorEntity> proveedorEntity = this.proveedorDAO.findById(id);
        if(proveedorEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            ProveedorEntity currenProveedor = proveedorEntity.get();
            return modelMapper.map(currenProveedor, ProveedorDTO.class);
        }else{
            return new ProveedorDTO();
        }
    }

    @Override
    public ProveedorDTO saveProveedor(ProveedorDTO proveedorDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            ProveedorEntity proveedorEntity = modelMapper.map(proveedorDTO, ProveedorEntity.class);
            this.proveedorDAO.saveProveedor(proveedorEntity);
            return proveedorDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el proveedor");
        }
    }

    @Override
    public ProveedorDTO updateProveedor(ProveedorDTO proveedorDTO, Long id) {
        Optional<ProveedorEntity> proveedorEntity = this.proveedorDAO.findById(id);
        if(proveedorEntity.isPresent()){
            ProveedorEntity currentProveedorEntity = proveedorEntity.get();
            currentProveedorEntity.setNomProveedor(proveedorDTO.getNomProveedor());
            currentProveedorEntity.setApeProveedor(proveedorDTO.getApeProveedor());
            currentProveedorEntity.setTeleProveedor(proveedorDTO.getTeleProveedor());
            currentProveedorEntity.setEmailProveedor(proveedorDTO.getEmailProveedor());
            currentProveedorEntity.setPaisProveedor(proveedorDTO.getPaisProveedor());
            this.proveedorDAO.updateProveedor(currentProveedorEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentProveedorEntity, ProveedorDTO.class);
        }else {
            throw new IllegalArgumentException("El proveedor no existe");
        }
    }

    @Override
    public String deleteProveedor(Long id) {
        Optional<ProveedorEntity> proveedorEntity = this.proveedorDAO.findById(id);
        if (proveedorEntity.isPresent()) {
            ProveedorEntity currentProveedorEntity = proveedorEntity.get();
            this.proveedorDAO.deleteProveedor(currentProveedorEntity);
            return "El proveedor con ID" + id + " ha sido eliminado";
        } else {
            return "El proveedor con ID" + id + " no existe";
        }
    }
}
