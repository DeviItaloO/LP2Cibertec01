package com.tutorias.cibertec.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProveedorDTO {

    private Long id;
    private String nomProveedor;
    private String apeProveedor;
    private int teleProveedor;
    private String emailProveedor;
    private String PaisProveedor;
}
