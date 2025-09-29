package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReporteDecoratorTest {
    static class DummyReporte implements Reporte {
        @Override public String generarReporte() { return "Reporte base"; }
        @Override public String getTitulo() { return "TituloX"; }
        @Override public LocalDate getFechaGeneracion() { return LocalDate.of(2025, 9, 28); }
        @Override public String getAutor() { return "AutorX"; }
        @Override public java.util.List<Transaccion> getTransacciones() { return Collections.emptyList(); }
        @Override public String getContenido() { return "ContenidoX"; }
    }

    static class DummyDecorator extends ReporteDecorator {
        public DummyDecorator(Reporte reporte) { super(reporte); }
        @Override public String generarReporte() { return reporte.generarReporte(); }
    }

    @Test
    void testDelegacionDeMetodos() {
        Reporte base = new DummyReporte();
        ReporteDecorator decorator = new DummyDecorator(base);

        assertEquals("TituloX", decorator.getTitulo());
        assertEquals(LocalDate.of(2025, 9, 28), decorator.getFechaGeneracion());
        assertEquals("AutorX", decorator.getAutor());
        assertEquals(Collections.emptyList(), decorator.getTransacciones());
        assertEquals("ContenidoX", decorator.getContenido());
        assertEquals("Reporte base", decorator.generarReporte());
    }

}

