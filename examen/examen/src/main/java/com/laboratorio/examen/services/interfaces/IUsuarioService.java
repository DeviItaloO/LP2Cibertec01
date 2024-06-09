package com.laboratorio.examen.services.interfaces;

import com.laboratorio.examen.model.UsuarioModel;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioModel> GetAllUsuarios();
    UsuarioModel findById(int id);
    UsuarioModel saveUsuario(UsuarioModel usuario);
    UsuarioModel updateUsuario(UsuarioModel usuarioModel, Integer id);
    String deleteUsuario(int id);
}
