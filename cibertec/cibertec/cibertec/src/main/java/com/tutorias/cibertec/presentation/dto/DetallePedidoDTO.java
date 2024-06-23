package com.tutorias.cibertec.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDTO {

    private Long id;
    private Long idPedido;
    private Long idProducto;
    private int cantidad;
    private int precioU;
}
