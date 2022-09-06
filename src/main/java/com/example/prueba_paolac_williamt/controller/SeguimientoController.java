package com.example.prueba_paolac_williamt.controller;


import com.example.prueba_paolac_williamt.model.Seguimiento;
import com.example.prueba_paolac_williamt.service.SeguimientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguimiento")
public class SeguimientoController {


    @Autowired
    SeguimientoServiceImpl seguimientoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Seguimiento>>listar() {
        List<Seguimiento> lista= seguimientoService.findByAll();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Seguimiento> crearLista(@RequestBody Seguimiento u) {
        return new ResponseEntity<>(seguimientoService.save(u), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Seguimiento> eliminarLista(@PathVariable String id) {
        seguimientoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // actualizar
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Seguimiento> actualizarLista(@PathVariable String id, @RequestBody Proyecto c) {

        Proyecto listaActual = seguimientoService.get(id);
        listaActual.setNombre(c.getNombre());
        listaActual.setCantidad(c.getCantidad());
        listaActual.setPrecio(c.getPrecio());
        listaActual.setDescripcion(c.getDescripcion());

        productoService.save(listaActual);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
