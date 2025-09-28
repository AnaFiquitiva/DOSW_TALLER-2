package edu.dosw.taller.DOSW_TALLER_2.controller.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReporteResponseDTO {
    private String id;
    private String titulo;
    private LocalDate fechaGeneracion;
    private String autor;
    private String contenido;
    private String contenidoFinal;
    private int totalTransacciones;
}