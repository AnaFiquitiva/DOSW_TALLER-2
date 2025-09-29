    package edu.dosw.taller.DOSW_TALLER_2.controller.dto;


    import lombok.Data;
    import java.math.BigDecimal;
    import java.time.LocalDate;

    @Data
    public class TransaccionDTO {
        private String id;
        private String descripcion;
        private BigDecimal monto;
        private LocalDate fecha;
        private String categoria;
    }