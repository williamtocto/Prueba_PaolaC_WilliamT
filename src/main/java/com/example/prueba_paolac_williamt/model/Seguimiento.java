package com.example.prueba_paolac_williamt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
@AllArgsConstructor
@Data
@Getter
@Setter
public class Seguimiento {


    private boolean estado;
    private String referencia;
    private String prioridad;
    private Date fecha_entrega;
    private String tarea;
    private String docente_responsable;
    private String descripcion;
    private String entregable;
    private int ejecutado;
    private String grupo;
    private double costos_fijos;
    private  int horas_estimadas;
    private  int horas_actuales;
    private String observacion;


}
