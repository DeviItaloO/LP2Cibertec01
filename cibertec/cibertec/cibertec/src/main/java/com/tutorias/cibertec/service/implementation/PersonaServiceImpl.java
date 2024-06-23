package com.tutorias.cibertec.service.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IPersonaDAO;
import com.tutorias.cibertec.persistence.entity.PersonaEntity;
import com.tutorias.cibertec.presentation.dto.PersonaDTO;
import com.tutorias.cibertec.service.interfaces.IPersonaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private IPersonaDAO personaDAO;

    @Override
    public List<PersonaDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();
        return this.personaDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, PersonaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonaDTO findById(Long id) {
        Optional<PersonaEntity> personaEntity = this.personaDAO.findById(id);
        if(personaEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            PersonaEntity currenPersona = personaEntity.get();
            return modelMapper.map(currenPersona, PersonaDTO.class);
        }else{
            return new PersonaDTO();
        }
    }

    @Override
    public PersonaDTO createPersona(PersonaDTO personaDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            PersonaEntity personaEntity = modelMapper.map(personaDTO, PersonaEntity.class);
            this.personaDAO.savePersona(personaEntity);
            return personaDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar a la persona");
        }
    }

    @Override
    public PersonaDTO updatePersona(PersonaDTO personaDTO, Long id) {
        Optional<PersonaEntity> personaEntity = this.personaDAO.findById(id);
        if(personaEntity.isPresent()){
            PersonaEntity currentPersonaEntity = personaEntity.get();
            currentPersonaEntity.setPrimerNombre(personaDTO.getPrimerNombre());
            currentPersonaEntity.setSegundoNombre(personaDTO.getSegundoNombre());
            currentPersonaEntity.setApellidoMaterno(personaDTO.getApellidoMaterno());
            currentPersonaEntity.setApellidoPaterno(personaDTO.getApellidoPaterno());
            currentPersonaEntity.setDni(personaDTO.getDni());
            currentPersonaEntity.setEstado(personaDTO.isEstado());
            currentPersonaEntity.setActivo(personaDTO.isActivo());
            this.personaDAO.updatePersona(currentPersonaEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentPersonaEntity, PersonaDTO.class);
        }else {
            throw new IllegalArgumentException("La persona no existe");
        }
    }

    @Override
    public String deletePersona(Long id) {
        Optional<PersonaEntity> personaEntity = this.personaDAO.findById(id);
        if (personaEntity.isPresent()) {
            PersonaEntity currentPersonaEntity = personaEntity.get();
            this.personaDAO.deletePersona(currentPersonaEntity);
            return "La Persona con ID" + id + " ha sido eliminado";
        } else {
            return "La Persona con ID" + id + " no existe";
        }
    }
}
