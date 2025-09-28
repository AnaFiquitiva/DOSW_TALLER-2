package edu.dosw.taller.DOSW_TALLER_2.controller.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class ReporteDTO {
    private String titulo;
    private LocalDate fechaGeneracion;
    private String autor;
    private String contenido;
    private List<TransaccionDTO> transacciones;
}
