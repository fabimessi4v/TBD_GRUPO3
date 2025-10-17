package Grupo3TBD.ClimateViewer.controllers;

import Grupo3TBD.ClimateViewer.DTO.ResumenSemanalDTO;
import Grupo3TBD.ClimateViewer.servic.ResumenSemanalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumensemanal")
@CrossOrigin
public class ResumenSemanalController {

    @Autowired
    private ResumenSemanalService resumenSemanalService;
    @GetMapping("/obtenerListaResumen/{idDataset}")
    public List<ResumenSemanalDTO> obtenerResumenSemanal(@PathVariable int idDataset){
        return resumenSemanalService.obtenerResumenSemanal();
    }

    @GetMapping("/obtenerListaResumenEspecifico/{idDataset}")
    public List<ResumenSemanalDTO> obtenerResumenSemanalEspecifico(@PathVariable int idDataset){
        return resumenSemanalService.obtenerResumenEspecifico(idDataset);
    }

    @PostMapping("/recalcularResumen/{idDataset}")
    public void recalcularResumen(@PathVariable int idDataset){
        resumenSemanalService.recalcularResumenSemanal(idDataset);
    }

    @PostMapping("/recalcularResumenyObtener/{idDataset}")
    public List<ResumenSemanalDTO> recalcularResumenyObtener(@PathVariable int idDataset){
        return resumenSemanalService.recalcularResumenSemanalyObtener(idDataset);
    }

}
