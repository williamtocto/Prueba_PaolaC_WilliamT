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
    public ResponseEntity<Seguimiento> actualizarLista(@PathVariable String id, @RequestBody Seguimiento c) {

        Seguimiento listaActual = seguimientoService.findById(id);
        listaActual.setEstado(c.isEstado());
        listaActual.setReferencia(c.getReferencia());
        listaActual.setDescripcion(c.getDescripcion());
        listaActual.setHoras_actuales(c.getHoras_actuales());
        listaActual.setHoras_estimadas(c.getHoras_estimadas());
        listaActual.setCostos_fijos(c.getCostos_fijos());
        listaActual.setGrupo(c.getGrupo());
        listaActual.setDocente_responsable(c.getDocente_responsable());
        listaActual.setEntregable(c.getEntregable());
        listaActual.setEjecutado(c.getEjecutado());
        listaActual.setTarea(c.getTarea());
        listaActual.setObservacion(c.getObservacion());
        listaActual.setFecha_entrega(c.getFecha_entrega());
        listaActual.setPrioridad(c.getPrioridad());
        seguimientoService.save(listaActual);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
