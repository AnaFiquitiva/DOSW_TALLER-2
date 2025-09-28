package edu.dosw.taller.DOSW_TALLER_2.controller;

import edu.dosw.taller.DOSW_TALLER_2.controller.dto.CrearReporteDTO;
import edu.dosw.taller.DOSW_TALLER_2.controller.dto.ReporteResponseDTO;
import edu.dosw.taller.DOSW_TALLER_2.model.Transaccion;
import edu.dosw.taller.DOSW_TALLER_2.service.interfaces.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    /**
     * Crea un nuevo reporte financiero con las opciones de decoración especificadas.
     */
    @PostMapping
    public ResponseEntity<String> crearReporte(@RequestBody CrearReporteDTO dto) {
        if (dto.getTransacciones() == null || dto.getTransacciones().isEmpty()) {
            return ResponseEntity.badRequest().body("La lista de transacciones no puede estar vacía.");
        }

        // Mapear TransaccionDTO → Transaccion
        List<Transaccion> transacciones = dto.getTransacciones().stream()
                .map(t -> {
                    Transaccion tr = new Transaccion();
                    tr.setDescripcion(t.getDescripcion());
                    tr.setMonto(t.getMonto());
                    tr.setFecha(t.getFecha());
                    tr.setCategoria(t.getCategoria());
                    return tr;
                })
                .collect(Collectors.toList());

        try {
            String id = reporteService.crearReporte(
                    dto.getTitulo(),
                    dto.getAutor(),
                    dto.getContenido(),
                    transacciones,
                    dto.isConGraficas(),
                    dto.isConMarcaAgua(),
                    dto.isConResumen(),
                    dto.isExportable()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el reporte: " + e.getMessage());
        }
    }

    /**
     * Obtiene todos los reportes generados.
     */
    @GetMapping
    public ResponseEntity<List<ReporteResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(reporteService.obtenerTodos().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList()));
    }

    /**
     * Filtra reportes por fecha de generación.
     */
    @GetMapping("/fecha")
    public ResponseEntity<List<ReporteResponseDTO>> filtrarPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(reporteService.filtrarPorFecha(fecha).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList()));
    }

    /**
     * Filtra reportes por autor (búsqueda insensible a mayúsculas).
     */
    @GetMapping("/autor")
    public ResponseEntity<List<ReporteResponseDTO>> filtrarPorAutor(@RequestParam String autor) {
        return ResponseEntity.ok(reporteService.filtrarPorAutor(autor).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList()));
    }

    /**
     * Filtra reportes por tipo de contenido (búsqueda insensible a mayúsculas).
     */
    @GetMapping("/contenido")
    public ResponseEntity<List<ReporteResponseDTO>> filtrarPorContenido(@RequestParam String tipo) {
        return ResponseEntity.ok(reporteService.filtrarPorContenido(tipo).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList()));
    }

    //  Convertir ReporteDocument → ReporteResponseDTO
    private ReporteResponseDTO convertirADTO(edu.dosw.taller.DOSW_TALLER_2.model.ReporteDocument doc) {
        ReporteResponseDTO dto = new ReporteResponseDTO();
        dto.setId(doc.getId());
        dto.setTitulo(doc.getTitulo());
        dto.setFechaGeneracion(doc.getFechaGeneracion());
        dto.setAutor(doc.getAutor());
        dto.setContenido(doc.getContenido());
        dto.setContenidoFinal(doc.getContenidoFinal());
        dto.setTotalTransacciones(doc.getTransacciones() != null ? doc.getTransacciones().size() : 0);
        return dto;
    }
}