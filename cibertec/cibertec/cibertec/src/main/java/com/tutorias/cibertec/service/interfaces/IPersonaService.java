package com.tutorias.cibertec.service.interfaces;

import com.tutorias.cibertec.presentation.dto.PersonaDTO;
import java.util.List;


public interface IPersonaService {
    List<PersonaDTO> findAll();
    PersonaDTO findById(Long id);
    PersonaDTO createPersona(PersonaDTO persona);
    PersonaDTO updatePersona(PersonaDTO persona, Long id);
    String deletePersona(Long id);
}
