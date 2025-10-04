package Grupo3TBD.ClimateViewer.entities;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Medicion {
    private Long id;
    private Double valor;
    private LocalDateTime fechaHora;
    private Long puntoMedicionId;
    private Long datasetId;


}