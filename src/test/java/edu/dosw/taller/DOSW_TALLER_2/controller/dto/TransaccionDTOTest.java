package edu.dosw.taller.DOSW_TALLER_2.controller.dto;


import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionDTOTest {

    @Test
    void testTransaccionDTOGettersSetters() {
        TransaccionDTO dto = new TransaccionDTO();


        dto.setId("TX123");
        dto.setDescripcion("Compra de materiales");
        dto.setMonto(BigDecimal.valueOf(150.750));
        dto.setFecha(LocalDate.of(2025, 9, 28));
        dto.setCategoria("Oficina");


        assertEquals("TX123", dto.getId());
        assertEquals("Compra de materiales", dto.getDescripcion());
        assertEquals(BigDecimal.valueOf(150.750), dto.getMonto());
        assertEquals(LocalDate.of(2025, 9, 28), dto.getFecha());
        assertEquals("Oficina", dto.getCategoria());
    }
}
