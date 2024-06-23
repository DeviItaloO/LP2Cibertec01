package com.tutorias.cibertec.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users1")
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String primerNombre;
    @Column
    private String segundoNombre;
    @Column
    private String apellidoPaterno;
    @Column
    private String apellidoMaterno;
    @Column
    private String dni;
    @Column
    private boolean estado;
    @Column
    private boolean activo;
}
