package com.laboratorio.examen.services.implementacion;

import com.laboratorio.examen.model.UsuarioModel;
import com.laboratorio.examen.repository.IUsuarioRepository;
import com.laboratorio.examen.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {
    IUsuarioRepository _usuarioRepository;

    @Autowired
    public IUsuarioServiceImpl(IUsuarioRepository usuarioRepository) {
        _usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioModel> GetAllUsuarios() {
        return _usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel findById(int id) {
        Optional<UsuarioModel> oUsuarioModel = _usuarioRepository.findById(id);
        if(oUsuarioModel.isPresent()){
            return oUsuarioModel.get();
        }else return new UsuarioModel();
    }

    @Override
    public UsuarioModel saveUsuario(UsuarioModel usuario) {
        UsuarioModel oUsuarioModel = _usuarioRepository.save(usuario);
        return oUsuarioModel;
    }

    @Override
    public UsuarioModel updateUsuario(UsuarioModel usuarioModel, Integer id) {
        Optional<UsuarioModel> oUsuarioModel = _usuarioRepository.findById(id);
        if(oUsuarioModel.isPresent()){
            UsuarioModel nUsuarioModel = oUsuarioModel.get();
            nUsuarioModel.setSPrimerNombre(usuarioModel.getSPrimerNombre());
            nUsuarioModel.setSSegundoNombre(usuarioModel.getSSegundoNombre());
            nUsuarioModel.setSPrimerApellido(usuarioModel.getSPrimerApellido());
            nUsuarioModel.setSSegundoApellido(usuarioModel.getSSegundoApellido());
            nUsuarioModel.setIEdad(usuarioModel.getIEdad());
            nUsuarioModel.setSDni(usuarioModel.getSDni());
            nUsuarioModel.setSCorreo(usuarioModel.getSCorreo());
            _usuarioRepository.save(nUsuarioModel);
            return nUsuarioModel;
        }else{
            throw new IllegalArgumentException("El usuario no existe");
        }
    }

    @Override
    public String deleteUsuario(int id) {
        Optional<UsuarioModel> oUsuarioModel = _usuarioRepository.findById(id);
        if(oUsuarioModel.isPresent()){
            UsuarioModel nUsuarioModel = oUsuarioModel.get();
            _usuarioRepository.delete(nUsuarioModel);
            return "El usuario con ID "+ id + " ha sido eliminado";
        }else{
            return "El usuario con ID "+ id + " no existe";
        }
    }
}
