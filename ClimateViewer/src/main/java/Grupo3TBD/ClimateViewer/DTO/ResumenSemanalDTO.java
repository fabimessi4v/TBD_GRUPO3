package Grupo3TBD.ClimateViewer.DTO;

import java.time.LocalDate;

public class ResumenSemanalDTO {
    private Integer idDataset;
    private LocalDate semana;
    private Double promedio;

    public ResumenSemanalDTO(Integer idDataset, LocalDate semana, Double promedio) {
        this.idDataset = idDataset;
        this.semana = semana;
        this.promedio = promedio;
    }

}


