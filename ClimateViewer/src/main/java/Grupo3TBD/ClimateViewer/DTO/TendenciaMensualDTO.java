package Grupo3TBD.ClimateViewer.DTO;

public class TendenciaMensualDTO {
    private String tipoSensor;
    private String mes;
    private double promedioMensual;
    private int cantidadMediciones;

    public TendenciaMensualDTO(String tipoSensor, String mes, double promedioMensual, int cantidadMediciones) {
        this.tipoSensor = tipoSensor;
        this.mes = mes;
        this.promedioMensual = promedioMensual;
        this.cantidadMediciones = cantidadMediciones;
    }

    public String getTipoSensor() { return tipoSensor; }
    public String getMes() { return mes; }
    public double getPromedioMensual() { return promedioMensual; }
    public int getCantidadMediciones() { return cantidadMediciones; }
}

