package com.tutorias.cibertec.persistence.dao.interfaces;

import com.tutorias.cibertec.persistence.entity.PersonaEntity;


import java.util.List;
import java.util.Optional;


public interface IPersonaDAO  {
    List<PersonaEntity> findAll();
    Optional<PersonaEntity> findById(Long id);
    void savePersona(PersonaEntity persona);
    void updatePersona(PersonaEntity persona);
    void deletePersona(PersonaEntity persona);
    Optional<PersonaEntity> findByCorreoAndContrasena(String correo, String contrasena);
    Optional<PersonaEntity> findByCorreo(String correo);
}
