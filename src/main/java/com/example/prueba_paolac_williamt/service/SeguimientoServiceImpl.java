package com.example.prueba_paolac_williamt.service;

import com.example.prueba_paolac_williamt.model.Proyecto;
import com.example.prueba_paolac_williamt.model.Seguimiento;
import com.example.prueba_paolac_williamt.repository.ProyectoRepository;
import com.example.prueba_paolac_williamt.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SeguimientoServiceImpl  extends GenericServiceImpl<Seguimiento, String> implements SeguimientoService{
    @Autowired
    SeguimientoRepository seguimientorepo;
    @Override
    public Seguimiento findByReference(String s) {
        return null;
    }

    @Override
    public CrudRepository<Seguimiento, String> getDao() {
        return seguimientorepo;
    }
}
