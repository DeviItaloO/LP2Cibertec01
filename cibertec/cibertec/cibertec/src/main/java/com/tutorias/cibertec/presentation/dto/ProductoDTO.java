package com.tutorias.cibertec.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long id;
    private Long idProveedor;
    private String nomProducto;
    private int precio;
    private int stock;
}
