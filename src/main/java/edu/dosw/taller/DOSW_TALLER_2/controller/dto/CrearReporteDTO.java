package edu.dosw.taller.DOSW_TALLER_2.controller.dto;

import lombok.Data;
import java.util.List;

@Data
public class CrearReporteDTO {
    private String titulo;
    private String autor;
    private String contenido;
    private List<TransaccionDTO> transacciones;


    private boolean conGraficas = false;
    private boolean conMarcaAgua = false;
    private boolean conResumen = false;
    private boolean exportable = false;
}
