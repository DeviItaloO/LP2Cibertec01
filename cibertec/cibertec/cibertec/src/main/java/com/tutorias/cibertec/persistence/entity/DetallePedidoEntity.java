package com.tutorias.cibertec.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Deta1")
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private PedidoEntity idPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private ProductoEntity idProducto;
    @Column
    private int cantidad;
    @Column
    private int precioU;
}
