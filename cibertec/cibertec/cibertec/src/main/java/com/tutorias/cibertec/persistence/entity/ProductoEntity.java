package com.tutorias.cibertec.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "prod1")
@NoArgsConstructor
@AllArgsConstructor

public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private ProveedorEntity idProveedor;

    @Column
    private String nomProducto;
    @Column
    private int precio;
    @Column
    private int stock;
}
