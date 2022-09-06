package com.example.prueba_paolac_williamt.controller;


import com.example.prueba_paolac_williamt.model.Proyecto;
import com.example.prueba_paolac_williamt.service.ProyectoService;
import com.example.prueba_paolac_williamt.service.ProyectoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {


    @Autowired
    ProyectoServiceImpl proyectoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Proyecto>>listar() {
        List<Proyecto> lista=proyectoService.findByAll();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<Proyecto> search(@PathVariable String reference) {
        return new ResponseEntity<>(proyectoService.findByReference(reference), HttpStatus.OK);
    }


    @PostMapping("/crear")
    public ResponseEntity<Proyecto> crearLista(@RequestBody Proyecto u) {
        return new ResponseEntity<>(proyectoService.save(u), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Proyecto> eliminarLista(@PathVariable String reference) {
        proyectoService.delete(reference);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // actualizar
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proyecto> actualizarLista(@PathVariable String id, @RequestBody Proyecto c) {

        Proyecto listaActual = proyectoService.FindByID(id);
        listaActual.setNombre_proyecto(c.getNombre_proyecto());
        listaActual.setObjetivo_estrategico(c.getObjetivo_estrategico());
        listaActual.setObjetivoOpertivo(c.getObjetivoOpertivo());
        listaActual.setObjetivo_tactico(c.getObjetivo_tactico());
        listaActual.setEstrategia(c.getEstrategia());


        proyectoService.save(listaActual);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
