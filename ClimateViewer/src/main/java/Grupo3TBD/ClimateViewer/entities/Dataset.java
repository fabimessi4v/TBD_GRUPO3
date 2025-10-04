package Grupo3TBD.ClimateViewer.entities;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Dataset {
    private Long id;
    private String nombre;
    private String descripcion;
    private String fuente;
    private LocalDate fechaActualizacion;

}