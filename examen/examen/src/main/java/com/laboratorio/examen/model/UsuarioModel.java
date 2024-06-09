package com.laboratorio.examen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int iId;
    @Column
    private String sPrimerNombre;
    @Column
    private String sSegundoNombre;
    @Column
    private String sPrimerApellido;
    @Column
    private String sSegundoApellido;
    @Column
    private int iEdad;
    @Column
    private String sDni;
    @Column
    private String sCorreo;
}
