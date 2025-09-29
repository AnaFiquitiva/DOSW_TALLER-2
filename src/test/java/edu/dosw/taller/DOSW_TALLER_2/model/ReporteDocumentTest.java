package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ReporteDocumentTest {


    @Test
    void testGettersAndSetters() {
        ReporteDocument doc = new ReporteDocument();
        doc.setId("1");
        doc.setTitulo("Titulo");
        doc.setFechaGeneracion(LocalDate.of(2025, 9, 28));
        doc.setAutor("Autor");
        doc.setTransacciones(Collections.emptyList());
        doc.setContenido("Contenido");
        doc.setContenidoFinal("Final");

        assertEquals("1", doc.getId());
        assertEquals("Titulo", doc.getTitulo());
        assertEquals("Autor", doc.getAutor());
        assertEquals("Contenido", doc.getContenido());
        assertEquals("Final", doc.getContenidoFinal());
        assertTrue(doc.getTransacciones().isEmpty());
    }

    @Test
    void testEqualsAndHashCode() {
        ReporteDocument d1 = new ReporteDocument();
        d1.setId("1");
        d1.setTitulo("T1");

        ReporteDocument d2 = new ReporteDocument();
        d2.setId("1");
        d2.setTitulo("T1");

        ReporteDocument d3 = new ReporteDocument();
        d3.setId("2");

        // mismo objeto
        assertEquals(d1, d1);

        // mismo contenido
        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());

        // distinto contenido
        assertNotEquals(d1, d3);

        // null y tipo distinto
        assertNotEquals(d1, null);
        assertNotEquals(d1, "otro tipo");
    }

    @Test
    void testToString() {
        ReporteDocument doc = new ReporteDocument();
        doc.setId("99");
        doc.setTitulo("TituloTest");

        String s = doc.toString();
        assertTrue(s.contains("99"));
        assertTrue(s.contains("TituloTest"));
    }


}

