package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReporteConResumenTest {

    @Test
    void testGenerarReporteConTransacciones() {
        Reporte dummyReporte = new Reporte() {
            @Override public String generarReporte() { return "Reporte base"; }
            @Override public String getTitulo() { return "Titulo"; }
            @Override public LocalDate getFechaGeneracion() { return LocalDate.now(); }
            @Override public String getAutor() { return "Autor"; }
            @Override public List<Transaccion> getTransacciones() {
                return Arrays.asList(
                        new Transaccion("1", "Compra1", BigDecimal.valueOf(100), LocalDate.now(), "Cat1"),
                        new Transaccion("2", "Compra2", BigDecimal.valueOf(50), LocalDate.now(), "Cat2")
                );
            }
            @Override public String getContenido() { return "Contenido"; }
        };

        ReporteConResumen reporte = new ReporteConResumen(dummyReporte);
        String resultado = reporte.generarReporte();

        assertTrue(resultado.contains("Reporte base"));
        assertTrue(resultado.contains("Total: $150"));
        assertTrue(resultado.contains("Promedio: $75.0"));
        assertTrue(resultado.contains("Número de transacciones: 2"));
    }

    @Test
    void testGenerarReporteSinTransacciones() {
        Reporte dummyReporte = new Reporte() {
            @Override public String generarReporte() { return "Reporte vacío"; }
            @Override public String getTitulo() { return "Titulo"; }
            @Override public LocalDate getFechaGeneracion() { return LocalDate.now(); }
            @Override public String getAutor() { return "Autor"; }
            @Override public List<Transaccion> getTransacciones() { return Collections.emptyList(); }
            @Override public String getContenido() { return "Contenido"; }
        };

        ReporteConResumen reporte = new ReporteConResumen(dummyReporte);
        String resultado = reporte.generarReporte();

        assertTrue(resultado.contains("Reporte vacío"));
        assertTrue(resultado.contains("Total: $0"));
        assertTrue(resultado.contains("Promedio: $0.0"));
        assertTrue(resultado.contains("Número de transacciones: 0"));
    }

}
