package com.tutorias.cibertec.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PedidoDTO {

    private Long id;
    private Long idPersona;
    private LocalDate fechaPedido;
    private int totalPedido;
}
