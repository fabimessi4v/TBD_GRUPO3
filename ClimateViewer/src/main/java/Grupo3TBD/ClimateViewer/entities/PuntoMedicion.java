package Grupo3TBD.ClimateViewer.entities;

import lombok.Data;

@Data
public class PuntoMedicion {
    private Long id;
    private String nombre;
    private double latitud;
    private double longitud;
    private String tipoSensor;
    private boolean activo;

}