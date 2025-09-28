package edu.dosw.taller.DOSW_TALLER_2.controller.dto;
import edu.dosw.taller.DOSW_TALLER_2.model.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteResponseDTO {
    private String id;
    private String titulo;
    private LocalDateTime fechaGeneracion;
    private String autor;
    private List<Transaccion> transacciones;
    private String contenido;
    private Map<String, Object> caracteristicasAdicionales;
}

