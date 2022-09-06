package com.example.prueba_paolac_williamt.service;

import com.example.prueba_paolac_williamt.model.Proyecto;

import com.example.prueba_paolac_williamt.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ProyectoServiceImpl extends GenericServiceImpl<Proyecto, String> implements ProyectoService{
    @Autowired
    ProyectoRepository proyectorepo;

    @Override
    public Proyecto findByReference(String s) {
        return null;
    }

    @Override
    public CrudRepository<Proyecto, String> getDao() {
        return proyectorepo;
    }
}
