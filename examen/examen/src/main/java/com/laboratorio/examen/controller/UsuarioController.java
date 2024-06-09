package com.laboratorio.examen.controller;

import com.laboratorio.examen.model.UsuarioModel;
import com.laboratorio.examen.services.interfaces.IUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    IUsuarioService _usuarioService;
    public UsuarioController(IUsuarioService usuarioService) {
        this._usuarioService = usuarioService;
    }

    //BUSCAR TODOS
    @GetMapping("/find")
    public List<UsuarioModel> getAll(){
        return _usuarioService.GetAllUsuarios();
    }

    //BUSCAR POR ID
    @GetMapping("/find/{id}")
    public UsuarioModel getAll(@PathVariable int id){
        return _usuarioService.findById(id);
    }

    //GRABAR
    @PostMapping("/save")
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario){
        return _usuarioService.saveUsuario(usuario);
    }

    //ACTUALIZAR
    @PutMapping("/update/{id}")
    public UsuarioModel updateUsuario(@RequestBody UsuarioModel usuario, @PathVariable int id){
        return _usuarioService.updateUsuario(usuario, id);
    }

    //ELIMINAR
    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable int id){
        return _usuarioService.deleteUsuario(id);
    }
}
