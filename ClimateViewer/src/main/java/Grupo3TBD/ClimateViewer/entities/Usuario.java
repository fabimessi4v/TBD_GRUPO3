package Grupo3TBD.ClimateViewer.entities;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Usuario {
    private Long id;
    private String nombre;
    private String email;
    private String passwordHash;
    private String rol;
    private LocalDate fechaRegistro;

}