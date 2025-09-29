package edu.dosw.taller.DOSW_TALLER_2.controller.dto;


import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;



class TransaccionDTOTest {

    @Test
    void testGettersSettersYMetodosLombok() {

        TransaccionDTO t1 = new TransaccionDTO();
        t1.setId("TX1");
        t1.setDescripcion("Compra");
        t1.setMonto(new BigDecimal("150.50"));
        t1.setFecha(LocalDate.of(2025, 9, 28));
        t1.setCategoria("Gastos");

        assertEquals("TX1", t1.getId());
        assertEquals("Compra", t1.getDescripcion());
        assertEquals(new BigDecimal("150.50"), t1.getMonto());
        assertEquals(LocalDate.of(2025, 9, 28), t1.getFecha());
        assertEquals("Gastos", t1.getCategoria());


        TransaccionDTO t2 = new TransaccionDTO();
        t2.setId("TX1");
        t2.setDescripcion("Compra");
        t2.setMonto(new BigDecimal("150.50"));
        t2.setFecha(LocalDate.of(2025, 9, 28));
        t2.setCategoria("Gastos");

        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());


        TransaccionDTO t3 = new TransaccionDTO();
        t3.setId("TX2");
        assertNotEquals(t1, t3);

        String str = t1.toString();
        assertNotNull(str);
        assertTrue(str.contains("TX1"));
        assertTrue(str.contains("Compra"));
        assertTrue(str.contains("150.50"));


        assertTrue(t1.canEqual(t2));
        assertFalse(t1.canEqual("string"));
    }
}
