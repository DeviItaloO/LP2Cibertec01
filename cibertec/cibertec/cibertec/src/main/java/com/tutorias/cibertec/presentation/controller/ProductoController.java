package com.tutorias.cibertec.presentation.controller;

import com.tutorias.cibertec.presentation.dto.ProductoDTO;
import com.tutorias.cibertec.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping("/find")
    public ResponseEntity<List<ProductoDTO>> findAll(){
        return new ResponseEntity<>(this.productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.productoService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductoDTO> saveProducto(@RequestBody ProductoDTO productoDTO){
        return new ResponseEntity<>(this.productoService.saveProducto(productoDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@RequestBody ProductoDTO productoDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.productoService.updateProducto(productoDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id){
        return new ResponseEntity<>(this.productoService.deleteProducto(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findByProveedor/{idProveedor}")
    public ResponseEntity<List<ProductoDTO>> findByProveedor(@PathVariable Long idProveedor) {
        return new ResponseEntity<>(this.productoService.findByProveedorId(idProveedor), HttpStatus.OK);
    }

}
