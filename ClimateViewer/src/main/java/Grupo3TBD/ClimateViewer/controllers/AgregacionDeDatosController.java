package Grupo3TBD.ClimateViewer.controllers;

import Grupo3TBD.ClimateViewer.DTO.AgregacionDeDatosDTO;
import Grupo3TBD.ClimateViewer.DTO.SerieTemporalRequestDTO;
import Grupo3TBD.ClimateViewer.servic.AgregacionDeDatosService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/agregaciondedatos")
@CrossOrigin
public class AgregacionDeDatosController {
    AgregacionDeDatosService agregacionDeDatosService;

    @PostMapping("/obtenerserietemporal")
    public List<AgregacionDeDatosDTO> obtenerSerieTemporal(@RequestBody SerieTemporalRequestDTO entrada) {
        return agregacionDeDatosService.obtenerSerieTemporal(
                entrada.getIdDataset(),
                entrada.getFechaComienzo(),
                entrada.getFechaTermino()
        );
    }
}
