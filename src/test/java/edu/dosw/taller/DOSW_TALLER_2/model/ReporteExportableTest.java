package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReporteExportableTest {

    @Test
    void testGenerarReporte() {
        Reporte dummyReporte = new Reporte() {
            @Override
            public String generarReporte() {
                return "Contenido reporte";
            }

            @Override public String getTitulo() { return "TituloX"; }
            @Override public LocalDate getFechaGeneracion() { return LocalDate.of(2025, 9, 28); }
            @Override public String getAutor() { return "AutorX"; }
            @Override public List<Transaccion> getTransacciones() { return Collections.emptyList(); }
            @Override public String getContenido() { return "Contenido"; }
        };

        ReporteExportable reporte = new ReporteExportable(dummyReporte);
        String resultado = reporte.generarReporte();

        assertTrue(resultado.contains("Contenido reporte"));
        assertTrue(resultado.contains("Exportable a PDF y Excel."));
        assertEquals("TituloX", reporte.getTitulo());
        assertEquals("AutorX", reporte.getAutor());
        assertEquals("Contenido", reporte.getContenido());
    }

}
