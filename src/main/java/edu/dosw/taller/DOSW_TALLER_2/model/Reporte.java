package edu.dosw.taller.DOSW_TALLER_2.model;

import java.time.LocalDate;
import java.util.List;

public interface Reporte {
    String getTitulo();
    LocalDate getFechaGeneracion();
    String getAutor();
    List<Transaccion> getTransacciones();
    String getContenido();
    String generarReporte();
}

