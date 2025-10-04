package Grupo3TBD.ClimateViewer.entities;


import lombok.Data;

@Data
public class Usuario {
    private Long id;
    private String nombre;
    private String email;
    private String passwordHash;

}