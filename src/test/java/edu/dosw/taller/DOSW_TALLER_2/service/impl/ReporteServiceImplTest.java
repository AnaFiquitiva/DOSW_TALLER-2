package edu.dosw.taller.DOSW_TALLER_2.service.impl;

import edu.dosw.taller.DOSW_TALLER_2.model.*;
import edu.dosw.taller.DOSW_TALLER_2.repository.ReporteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReporteServiceImplTest {

    private ReporteRepository reporteRepository;
    private ReporteServiceImpl reporteService;

    @BeforeEach
    void setUp() {
        reporteRepository = mock(ReporteRepository.class);
        reporteService = new ReporteServiceImpl(reporteRepository);
    }

    @Test
    void crearReporte_basicoExitoso() {
        Transaccion t = new Transaccion();
        List<Transaccion> transacciones = List.of(t);

        ReporteDocument savedDoc = new ReporteDocument();
        savedDoc.setId("123");
        when(reporteRepository.save(any())).thenReturn(savedDoc);

        String id = reporteService.crearReporte(
                "Titulo", "Autor", "Contenido", transacciones,
                false, false, false, false
        );

        assertEquals("123", id);

        ArgumentCaptor<ReporteDocument> captor = ArgumentCaptor.forClass(ReporteDocument.class);
        verify(reporteRepository).save(captor.capture());
        assertEquals("Titulo", captor.getValue().getTitulo());
        assertEquals("Autor", captor.getValue().getAutor());
    }

    @Test
    void crearReporte_conDecoradores() {
        Transaccion t = new Transaccion();
        t.setMonto(BigDecimal.valueOf(100));
        List<Transaccion> transacciones = List.of(t);

        ReporteDocument savedDoc = new ReporteDocument();
        savedDoc.setId("456");
        when(reporteRepository.save(any())).thenReturn(savedDoc);

        String id = reporteService.crearReporte(
                "Titulo", "Autor", "Contenido", transacciones,
                true, true, true, true
        );

        assertEquals("456", id);
        verify(reporteRepository).save(any());
    }


    @Test
    void crearReporte_listaVacia_lanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                reporteService.crearReporte("T", "A", "C", Collections.emptyList(), false, false, false, false)
        );
        assertEquals("La lista de transacciones no puede estar vacía.", ex.getMessage());
    }

    @Test
    void obtenerTodos_retornaLista() {
        when(reporteRepository.findAll()).thenReturn(List.of(new ReporteDocument()));
        List<ReporteDocument> result = reporteService.obtenerTodos();
        assertEquals(1, result.size());
    }

    @Test
    void filtrarPorFecha_retornaCorrecto() {
        LocalDate fecha = LocalDate.now();
        ReporteDocument doc = new ReporteDocument();
        doc.setFechaGeneracion(fecha);
        when(reporteRepository.findAll()).thenReturn(List.of(doc));

        List<ReporteDocument> filtrados = reporteService.filtrarPorFecha(fecha);
        assertEquals(1, filtrados.size());
    }

    @Test
    void filtrarPorAutor_retornaCorrecto() {
        ReporteDocument doc = new ReporteDocument();
        doc.setAutor("Juan");
        when(reporteRepository.findAll()).thenReturn(List.of(doc));

        List<ReporteDocument> filtrados = reporteService.filtrarPorAutor("juan");
        assertEquals(1, filtrados.size());
    }

    @Test
    void filtrarPorContenido_nullRetornaTodos() {
        ReporteDocument doc = new ReporteDocument();
        doc.setContenido("contenido");
        when(reporteRepository.findAll()).thenReturn(List.of(doc));

        List<ReporteDocument> filtrados = reporteService.filtrarPorContenido(null);
        assertEquals(1, filtrados.size());

        filtrados = reporteService.filtrarPorContenido("   ");
        assertEquals(1, filtrados.size());
    }

    @Test
    void filtrarPorContenido_busquedaCorrecta() {
        ReporteDocument doc = new ReporteDocument();
        doc.setContenido("Este es un contenido de prueba");
        when(reporteRepository.findAll()).thenReturn(List.of(doc));

        List<ReporteDocument> filtrados = reporteService.filtrarPorContenido("contenido");
        assertEquals(1, filtrados.size());

        filtrados = reporteService.filtrarPorContenido("no-existe");
        assertEquals(0, filtrados.size());
    }
}
