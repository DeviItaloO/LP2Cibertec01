package com.tutorias.cibertec.presentation.controller;

import com.tutorias.cibertec.presentation.dto.PersonaDTO;
import com.tutorias.cibertec.service.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    //BUSCAR PERSONAS
    @GetMapping("/find")
    public ResponseEntity<List<PersonaDTO>> findAll() {
        return new ResponseEntity<>(this.personaService.findAll(), HttpStatus.OK);
    }

    //BUSCAR UNA PERSONA POR ID
    @GetMapping("/find/{id}")
    public ResponseEntity<PersonaDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.personaService.findById(id), HttpStatus.OK);
    }

    //CREAR PERSONA
    @PostMapping("/create")
    public ResponseEntity<PersonaDTO> createPersona(@RequestBody PersonaDTO personaDTO){
        return new ResponseEntity<>(this.personaService.createPersona(personaDTO), HttpStatus.CREATED);
    }

    //ACTUALIZAR PERSONA
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaDTO> updatePersona(@RequestBody PersonaDTO personaDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.personaService.updatePersona(personaDTO, id), HttpStatus.OK);
    }

    //ELIMINAR PERSONA
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id){
        return new ResponseEntity<>(this.personaService.deletePersona(id), HttpStatus.NO_CONTENT);
    }
}
