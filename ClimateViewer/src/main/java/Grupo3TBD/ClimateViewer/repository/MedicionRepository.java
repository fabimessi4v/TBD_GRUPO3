package Grupo3TBD.ClimateViewer.repository;


import Grupo3TBD.ClimateViewer.DTO.CorrelacionDTO;
import Grupo3TBD.ClimateViewer.DTO.EventoExtremoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * Obtiene una lista de eventos extremos de temperatura registrados en el último año.
     *
     * Cada evento corresponde a un día en el que la temperatura máxima registrada por
     * cualquier punto de medición de tipo "Termómetro" superó los 35°C.
     *
     * @return Lista de objetos EventoExtremoDTO, cada uno con la fecha y el valor máximo de temperatura de ese día.
     */
    public List<EventoExtremoDTO> findEventosExtremosTemperaturaUltimoAno() {
        String sql = """
            SELECT
                DATE(m.fechahora) AS fecha,
                MAX(m.valor) AS maxima_temperatura
            FROM
                mediciones m
                INNER JOIN puntosmedicion p ON m.idpunto = p.idpunto
            WHERE
                p.tiposensor = 'Termómetro'
                AND m.valor > 35
                AND m.fechahora >= CURRENT_DATE - INTERVAL '1 year'
            GROUP BY
                DATE(m.fechahora)
            ORDER BY
                fecha ASC
            """;
        // Ejecuta la consulta y mapea cada fila del resultado a un objeto EventoExtremoDTO.
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {
                    EventoExtremoDTO dto = new EventoExtremoDTO();
                    dto.setFecha(rs.getDate("fecha").toLocalDate());
                    dto.setMaximaTemperatura(rs.getDouble("maxima_temperatura"));
                    return dto;
                }
        );
    }
}