package com.example.prueba_paolac_williamt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {


    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Proyecto>>listar() {
        List<Proyecto> lista=proyectoService.findAll();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Proyecto> crearLista(@RequestBody Proyecto u) {
        return new ResponseEntity<>(proyectoService.save(u), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Proyecto> eliminarLista(@PathVariable Long id) {
        proyectoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // actualizar
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proyecto> actualizarLista(@PathVariable String id, @RequestBody Proyecto c) {

        Proyecto listaActual = proyectoService.get(id);
        listaActual.setNombre(c.getNombre());
        listaActual.setCantidad(c.getCantidad());
        listaActual.setPrecio(c.getPrecio());
        listaActual.setDescripcion(c.getDescripcion());

        productoService.save(listaActual);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
