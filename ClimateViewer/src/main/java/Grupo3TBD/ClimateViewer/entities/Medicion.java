package Grupo3TBD.ClimateViewer.entities;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Medicion {
    private Long id;
    private PuntoMedicion puntoMedicion;
    private Dataset dataset;
    private Long valor;
    private LocalDate fechahora;


}