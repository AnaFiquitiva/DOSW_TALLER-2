package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ReporteExportableTest {

    private Reporte reporteBase;

    @BeforeEach
    void setUp() {

        reporteBase = new Reporte() {
            @Override
            public String getTitulo() { return "Reporte base"; }

            @Override
            public LocalDate getFechaGeneracion() { return LocalDate.of(2025, 9, 28); }

            @Override
            public String getAutor() { return "Andrés"; }

            @Override
            public java.util.List<Transaccion> getTransacciones() { return Collections.emptyList(); }

            @Override
            public String getContenido() { return "Contenido"; }

            @Override
            public String generarReporte() { return "Este es el reporte original"; }
        };
    }

    @Test
    void testGenerarReporteIncluyeReporteBaseYExportable() {
        ReporteExportable reporte = new ReporteExportable(reporteBase);

        String resultado = reporte.generarReporte();


        assertTrue(resultado.contains("Este es el reporte original"));


        assertTrue(resultado.contains("[+] Exportable a PDF y Excel."));
    }
}
