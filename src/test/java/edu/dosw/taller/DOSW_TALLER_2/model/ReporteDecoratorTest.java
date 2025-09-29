package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReporteDecoratorTest {

    private Reporte reporteFake;
    private ReporteDecorator decorator;

    @BeforeEach
    void setUp() {

        reporteFake = new Reporte() {
            @Override
            public String getTitulo() { return "Título de prueba"; }

            @Override
            public LocalDate getFechaGeneracion() { return LocalDate.of(2025, 9, 28); }

            @Override
            public String getAutor() { return "Andrés"; }

            @Override
            public List<Transaccion> getTransacciones() {
                return List.of(new Transaccion("Compra X", BigDecimal.valueOf(99.99)));
            }

            @Override
            public String getContenido() { return "Contenido base"; }

            @Override
            public String generarReporte() { return "Reporte base generado"; }
        };


        decorator = new ReporteDecorator(reporteFake) {
            @Override
            public String generarReporte() {
                return "Reporte decorado";
            }
        };
    }

    @Test
    void testDelegarGetTitulo() {
        assertEquals("Título de prueba", decorator.getTitulo());
    }

    @Test
    void testDelegarGetFechaGeneracion() {
        assertEquals(LocalDate.of(2025, 9, 28), decorator.getFechaGeneracion());
    }

    @Test
    void testDelegarGetAutor() {
        assertEquals("Andrés", decorator.getAutor());
    }

    @Test
    void testDelegarGetTransacciones() {
        List<Transaccion> transacciones = decorator.getTransacciones();
        assertEquals(1, transacciones.size());
        assertEquals("Compra X", transacciones.get(0).getDescripcion());
        assertEquals(BigDecimal.valueOf(99.99), transacciones.get(0).getMonto());
    }

    @Test
    void testDelegarGetContenido() {
        assertEquals("Contenido base", decorator.getContenido());
    }
}

