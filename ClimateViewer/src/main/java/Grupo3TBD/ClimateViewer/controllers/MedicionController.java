package Grupo3TBD.ClimateViewer.controllers;

import Grupo3TBD.ClimateViewer.DTO.EventoExtremoDTO;
import Grupo3TBD.ClimateViewer.repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mediciones")
public class MedicionController {

    @Autowired
    private MedicionRepository medicionRepository;
    /**
     * Obtiene la lista de eventos extremos de temperatura registrados en el último año.
     *
     * Un evento extremo se define como un día en el que la temperatura máxima registrada
     * por algún punto de medición (de tipo "Termómetro") fue mayor a 35°C.
     *
     * @return Lista de objetos EventoExtremoDTO con fecha y máxima temperatura de cada evento.
     */
    @GetMapping("/eventos-extremos-temperatura")
    public List<EventoExtremoDTO> getEventosExtremosTemperaturaUltimoAno() {
        return medicionRepository.findEventosExtremosTemperaturaUltimoAno();
    }
}