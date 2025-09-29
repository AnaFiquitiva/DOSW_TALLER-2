package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransaccionTest {
    @Test
    void testConstructorConParametrosYGetters() {
        LocalDate fecha = LocalDate.of(2025, 9, 28);
        Transaccion t = new Transaccion("1", "Compra", BigDecimal.valueOf(200), fecha, "Alimentos");

        assertEquals("1", t.getId());
        assertEquals("Compra", t.getDescripcion());
        assertEquals(BigDecimal.valueOf(200), t.getMonto());
        assertEquals(fecha, t.getFecha());
        assertEquals("Alimentos", t.getCategoria());
    }

    @Test
    void testSettersYGetters() {
        Transaccion t = new Transaccion();
        LocalDate fecha = LocalDate.of(2025, 1, 1);

        t.setId("2");
        t.setDescripcion("Servicio");
        t.setMonto(BigDecimal.valueOf(500));
        t.setFecha(fecha);
        t.setCategoria("Transporte");

        assertEquals("2", t.getId());
        assertEquals("Servicio", t.getDescripcion());
        assertEquals(BigDecimal.valueOf(500), t.getMonto());
        assertEquals(fecha, t.getFecha());
        assertEquals("Transporte", t.getCategoria());
    }
}
