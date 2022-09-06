package com.example.prueba_paolac_williamt.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
public class Proyecto {
    @Id
    private String Referencia;
    private String nombre_proyecto;
    private String objetivo_estrategico;
    private double objetivo_tactico;
    private String estrategia;
    private String objetivoOpertivo;


}
