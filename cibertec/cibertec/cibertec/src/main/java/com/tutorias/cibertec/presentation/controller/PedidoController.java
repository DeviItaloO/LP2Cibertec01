package com.tutorias.cibertec.presentation.controller;

import com.tutorias.cibertec.presentation.dto.PedidoDTO;
import com.tutorias.cibertec.service.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping("/find")
    public ResponseEntity<List<PedidoDTO>> findAll(){
        return new ResponseEntity<>(this.pedidoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.pedidoService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PedidoDTO> savePedido(@RequestBody PedidoDTO pedidoDTO){
        return new ResponseEntity<>(this.pedidoService.savePedido(pedidoDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@RequestBody PedidoDTO pedidoDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.pedidoService.updatePedido(pedidoDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePedido(@PathVariable Long id){
        return new ResponseEntity<>(this.pedidoService.deletePedido(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findByPersona/{idPersona}")
    public ResponseEntity<List<PedidoDTO>> findByPersona(@PathVariable Long idPersona) {
        return new ResponseEntity<>(this.pedidoService.findByPersonaId(idPersona), HttpStatus.OK);
    }
}
