package edu.dosw.taller.DOSW_TALLER_2.controller;



import edu.dosw.taller.DOSW_TALLER_2.controller.dto.*;
import edu.dosw.taller.DOSW_TALLER_2.model.ReporteDocument;
import edu.dosw.taller.DOSW_TALLER_2.service.interfaces.ReporteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReporteControllerTest {

    @InjectMocks
    private ReporteController reporteController;

    @Mock
    private ReporteService reporteService;

    private CrearReporteDTO crearReporteDTO;
    private TransaccionDTO transaccionDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        transaccionDTO = new TransaccionDTO();
        transaccionDTO.setId("T1");
        transaccionDTO.setDescripcion("Compra");
        transaccionDTO.setMonto(java.math.BigDecimal.valueOf(100));
        transaccionDTO.setFecha(LocalDate.now());
        transaccionDTO.setCategoria("Gastos");

        crearReporteDTO = new CrearReporteDTO();
        crearReporteDTO.setTitulo("Reporte Test");
        crearReporteDTO.setAutor("Ana");
        crearReporteDTO.setContenido("Contenido de prueba");
        crearReporteDTO.setTransacciones(List.of(transaccionDTO));
        crearReporteDTO.setConGraficas(true);
        crearReporteDTO.setConMarcaAgua(true);
        crearReporteDTO.setConResumen(true);
        crearReporteDTO.setExportable(true);
    }

    @Test
    void crearReporte_valido_devuelve201() {
        when(reporteService.crearReporte(any(), any(), any(), anyList(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean()))
                .thenReturn("ID123");

        var response = reporteController.crearReporte(crearReporteDTO);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("ID123", response.getBody());
    }

    @Test
    void crearReporte_transaccionesVacias_devuelve400() {
        crearReporteDTO.setTransacciones(new ArrayList<>());
        var response = reporteController.crearReporte(crearReporteDTO);
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    void crearReporte_servicioExcepcion_devuelve500() {
        when(reporteService.crearReporte(any(), any(), any(), anyList(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean()))
                .thenThrow(new RuntimeException("Error interno"));

        var response = reporteController.crearReporte(crearReporteDTO);
        assertEquals(500, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("Error al crear el reporte"));
    }

    @Test
    void obtenerTodos_devuelveLista() {
        ReporteDocument doc = new ReporteDocument();
        doc.setId("1");
        doc.setTitulo("Reporte");
        doc.setAutor("Ana");
        doc.setContenido("Contenido");
        doc.setFechaGeneracion(LocalDate.now());
        doc.setTransacciones(List.of());

        when(reporteService.obtenerTodos()).thenReturn(List.of(doc));

        var response = reporteController.obtenerTodos();
        assertEquals(1, response.getBody().size());
        assertEquals("Reporte", response.getBody().get(0).getTitulo());
    }

    @Test
    void filtrarPorFecha_devuelveLista() {
        ReporteDocument doc = new ReporteDocument();
        doc.setFechaGeneracion(LocalDate.of(2025, 9, 28));
        when(reporteService.filtrarPorFecha(LocalDate.of(2025, 9, 28))).thenReturn(List.of(doc));

        var response = reporteController.filtrarPorFecha(LocalDate.of(2025, 9, 28));
        assertEquals(1, response.getBody().size());
    }

    @Test
    void filtrarPorAutor_devuelveLista() {
        ReporteDocument doc = new ReporteDocument();
        doc.setAutor("Ana");
        when(reporteService.filtrarPorAutor("Ana")).thenReturn(List.of(doc));

        var response = reporteController.filtrarPorAutor("Ana");
        assertEquals(1, response.getBody().size());
    }

    @Test
    void filtrarPorContenido_devuelveLista() {
        ReporteDocument doc = new ReporteDocument();
        doc.setContenido("Importante");
        when(reporteService.filtrarPorContenido("Importante")).thenReturn(List.of(doc));

        var response = reporteController.filtrarPorContenido("Importante");
        assertEquals(1, response.getBody().size());
    }
}
