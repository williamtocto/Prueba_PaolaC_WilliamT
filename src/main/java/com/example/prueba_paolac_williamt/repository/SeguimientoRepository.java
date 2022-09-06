package com.example.prueba_paolac_williamt.repository;



import com.example.prueba_paolac_williamt.model.Seguimiento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeguimientoRepository extends MongoRepository<Seguimiento, Long> {
}
