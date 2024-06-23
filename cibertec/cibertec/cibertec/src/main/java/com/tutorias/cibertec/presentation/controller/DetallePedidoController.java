package com.tutorias.cibertec.presentation.controller;

import com.tutorias.cibertec.presentation.dto.DetallePedidoDTO;
import com.tutorias.cibertec.service.interfaces.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoController {
    @Autowired
    private IDetallePedidoService detallePedidoService;

    @GetMapping("/find")
    public ResponseEntity<List<DetallePedidoDTO>> findAll() {
        return new ResponseEntity<>(this.detallePedidoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DetallePedidoDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.detallePedidoService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<DetallePedidoDTO> saveDetallePedido(@RequestBody DetallePedidoDTO detallePedidoDTO) {
        return new ResponseEntity<>(this.detallePedidoService.saveDetallePedido(detallePedidoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DetallePedidoDTO> updateDetallePedido(@RequestBody DetallePedidoDTO detallePedidoDTO, @PathVariable Long id) {
        return new ResponseEntity<>(this.detallePedidoService.updateDetallePedido(detallePedidoDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDetallePedido(@PathVariable Long id) {
        return new ResponseEntity<>(this.detallePedidoService.deleteDetallePedido(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findByPedido/{idPedido}")
    public ResponseEntity<List<DetallePedidoDTO>> findByPedido(@PathVariable Long idPedido) {
        return new ResponseEntity<>(this.detallePedidoService.findByPedido(idPedido), HttpStatus.OK);
    }

    @GetMapping("/findByProducto/{idProducto}")
    public ResponseEntity<List<DetallePedidoDTO>> findByProducto(@PathVariable Long idProducto) {
        return new ResponseEntity<>(this.detallePedidoService.findByProducto(idProducto), HttpStatus.OK);
    }
}
