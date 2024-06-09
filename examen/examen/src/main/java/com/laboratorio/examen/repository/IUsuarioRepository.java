package com.laboratorio.examen.repository;

import com.laboratorio.examen.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}
