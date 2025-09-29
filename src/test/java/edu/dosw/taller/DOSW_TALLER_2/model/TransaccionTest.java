package edu.dosw.taller.DOSW_TALLER_2.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {


    @Test
    void testConstructorAndGetters() {
        LocalDate fecha = LocalDate.now();
        Transaccion t = new Transaccion("1", "Compra", BigDecimal.TEN, fecha, "Alimentos");

        assertEquals("1", t.getId());
        assertEquals("Compra", t.getDescripcion());
        assertEquals(BigDecimal.TEN, t.getMonto());
        assertEquals(fecha, t.getFecha());
        assertEquals("Alimentos", t.getCategoria());
    }

    @Test
    void testSetters() {
        Transaccion t = new Transaccion();
        LocalDate fecha = LocalDate.of(2023, 1, 1);

        t.setId("2");
        t.setDescripcion("Venta");
        t.setMonto(BigDecimal.ONE);
        t.setFecha(fecha);
        t.setCategoria("Servicios");

        assertEquals("2", t.getId());
        assertEquals("Venta", t.getDescripcion());
        assertEquals(BigDecimal.ONE, t.getMonto());
        assertEquals(fecha, t.getFecha());
        assertEquals("Servicios", t.getCategoria());
    }

    @Test
    void testEqualsAndHashCode() {
        LocalDate fecha = LocalDate.now();
        Transaccion t1 = new Transaccion("1", "Compra", BigDecimal.TEN, fecha, "Cat");
        Transaccion t2 = new Transaccion("1", "Compra", BigDecimal.TEN, fecha, "Cat");
        Transaccion t3 = new Transaccion("2", "Venta", BigDecimal.ONE, fecha, "Cat");

        // mismo objeto
        assertEquals(t1, t1);

        // mismo contenido
        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());

        // distinto contenido
        assertNotEquals(t1, t3);

        // null y tipo distinto
        assertNotEquals(t1, null);
        assertNotEquals(t1, "string");
    }

    @Test
    void testToString() {
        Transaccion t = new Transaccion("1", "Compra", BigDecimal.TEN, LocalDate.now(), "Cat");
        String s = t.toString();
        assertTrue(s.contains("Compra"));
        assertTrue(s.contains("Cat"));
    }


}
