package com.example.prueba_paolac_williamt.repository;


import com.example.prueba_paolac_williamt.model.Proyecto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProyectoRepository extends MongoRepository<Proyecto, String> {
}
