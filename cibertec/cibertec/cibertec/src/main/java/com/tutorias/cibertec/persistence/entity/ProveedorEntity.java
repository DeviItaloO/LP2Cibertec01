package com.tutorias.cibertec.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Provee1")
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomProveedor;
    @Column
    private String apeProveedor;
    @Column
    private int teleProveedor;
    @Column
    private String emailProveedor;
    @Column
    private String PaisProveedor;

}
