package Grupo3TBD.ClimateViewer.repository;

import Grupo3TBD.ClimateViewer.DTO.CorrelacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PuntoMedicionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * Busca los puntos de medición de tipo "Sensor CO2" que se encuentran a menos de 50 km
     * de un punto de medición de temperatura específico.
     *
     * Utiliza la fórmula del haversine para calcular la distancia geodésica entre los puntos.
     *
     * @param idPuntoTemperatura El ID del punto de medición de temperatura.
     * @return Lista de objetos CorrelacionDTO que contienen los IDs de los puntos y la distancia entre ellos.
     */

    public List<CorrelacionDTO> findCO2CercanosPorPuntoTemperatura(Long idPuntoTemperatura) {
        String sql = """
            SELECT
                temp.idpunto AS idPuntoTemperatura,
                co2.idpunto AS idPuntoCO2,
                ROUND(
                    (
                        6371 * acos(
                            cos(radians(temp.latitud)) * cos(radians(co2.latitud)) *
                            cos(radians(co2.longitud) - radians(temp.longitud)) +
                            sin(radians(temp.latitud)) * sin(radians(co2.latitud))
                        )
                    )::numeric, 2
                ) AS distanciaKm
            FROM puntosmedicion temp
            JOIN puntosmedicion co2 ON co2.tiposensor = 'Sensor CO2'
            WHERE temp.tiposensor = 'Termómetro'
              AND temp.idpunto = ?
              AND (
                    6371 * acos(
                        cos(radians(temp.latitud)) * cos(radians(co2.latitud)) *
                        cos(radians(co2.longitud) - radians(temp.longitud)) +
                        sin(radians(temp.latitud)) * sin(radians(co2.latitud))
                    )
                ) < 50
              AND temp.idpunto <> co2.idpunto
            """;
        // Ejecuta la consulta y mapea cada fila del resultado a un objeto CorrelacionDTO.
        return jdbcTemplate.query(sql, new Object[]{idPuntoTemperatura}, (rs, rowNum) -> mapCorrelacion(rs));
    }
    /**
     * Mapea el resultado de la consulta SQL a un objeto CorrelacionDTO.
     *
     * @param rs ResultSet con los datos de la consulta.
     * @return CorrelacionDTO con los datos de la correlación geoespacial.
     * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
     */
    private CorrelacionDTO mapCorrelacion(ResultSet rs) throws SQLException {
        CorrelacionDTO dto = new CorrelacionDTO();
        dto.setIdPuntoTemperatura(rs.getLong("idPuntoTemperatura"));
        dto.setIdPuntoCO2(rs.getLong("idPuntoCO2"));
        dto.setDistanciaKm(rs.getDouble("distanciaKm"));
        return dto;
    }
}