package edu.dosw.taller.DOSW_TALLER_2.controller;

import edu.dosw.taller.DOSW_TALLER_2.controller.dto.CrearReporteDTO;
import edu.dosw.taller.DOSW_TALLER_2.controller.dto.TransaccionDTO;
import edu.dosw.taller.DOSW_TALLER_2.service.interfaces.ReporteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReporteControllerTest {

    @Mock
    private ReporteService reporteService;

    @InjectMocks
    private ReporteController reporteController;

    private CrearReporteDTO dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        TransaccionDTO t1 = new TransaccionDTO();
        t1.setId("1");
        t1.setDescripcion("Compra de papelería");
        t1.setMonto(BigDecimal.valueOf(150));
        t1.setFecha(LocalDate.now());
        t1.setCategoria("Oficina");


        dto = new CrearReporteDTO();
        dto.setTitulo("Reporte Mensual");
        dto.setAutor("Valeria");
        dto.setContenido("Contenido del reporte");
        dto.setConGraficas(true);
        dto.setConMarcaAgua(true);
        dto.setConResumen(false);
        dto.setExportable(true);
        dto.setTransacciones(List.of(t1));
    }

    @Test
    void crearReporte_deberiaRetornarCREATED() {

        when(reporteService.crearReporte(
                anyString(), anyString(), anyString(), anyList(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean()
        )).thenReturn("12345");


        ResponseEntity<String> response = reporteController.crearReporte(dto);


        assertEquals(201, response.getStatusCodeValue());
        assertEquals("12345", response.getBody());


        verify(reporteService, times(1)).crearReporte(
                eq(dto.getTitulo()),
                eq(dto.getAutor()),
                eq(dto.getContenido()),
                anyList(),
                eq(dto.isConGraficas()),
                eq(dto.isConMarcaAgua()),
                eq(dto.isConResumen()),
                eq(dto.isExportable())
        );
    }

    @Test
    void crearReporte_conListaVacia_deberiaRetornarBadRequest() {
        dto.setTransacciones(List.of());

        ResponseEntity<String> response = reporteController.crearReporte(dto);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("La lista de transacciones no puede estar vacía.", response.getBody());

        verifyNoInteractions(reporteService);
    }
}

