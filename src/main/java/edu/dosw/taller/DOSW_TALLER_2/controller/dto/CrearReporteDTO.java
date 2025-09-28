package edu.dosw.taller.DOSW_TALLER_2.controller.dto;

import edu.dosw.taller.DOSW_TALLER_2.model.Transaccion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrearReporteDTO {
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    private List<Transaccion> transacciones;
    private String contenido;
    private List<String> mejoras; // graficas, seguridad, resumen, exportacion
}