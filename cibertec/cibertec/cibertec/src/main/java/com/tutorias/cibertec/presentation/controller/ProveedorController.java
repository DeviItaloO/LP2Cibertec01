package com.tutorias.cibertec.presentation.controller;

import com.tutorias.cibertec.presentation.dto.ProveedorDTO;
import com.tutorias.cibertec.service.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/find")
    public ResponseEntity<List<ProveedorDTO>> findAll(){
        return new ResponseEntity<>(this.proveedorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProveedorDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.proveedorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProveedorDTO> saveProveedor(@RequestBody ProveedorDTO proveedorDTO){
        return new  ResponseEntity<>(this.proveedorService.saveProveedor(proveedorDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProveedorDTO> updateProveedor(@RequestBody ProveedorDTO proveedorDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.proveedorService.updateProveedor(proveedorDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProveedor(@PathVariable Long id){
        return new ResponseEntity<>(this.proveedorService.deleteProveedor(id), HttpStatus.NO_CONTENT);
    }
}
