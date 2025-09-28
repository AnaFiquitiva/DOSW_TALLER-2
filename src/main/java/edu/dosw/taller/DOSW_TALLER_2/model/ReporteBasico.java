package edu.dosw.taller.DOSW_TALLER_2.model;

import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

@Getter
public class ReporteBasico implements Reporte {
    private final String titulo;
    private final LocalDate fechaGeneracion;
    private final String autor;
    private final List<Transaccion> transacciones;
    private final String contenido;

    public ReporteBasico(String titulo, LocalDate fechaGeneracion, String autor,
                         List<Transaccion> transacciones, String contenido) {
        this.titulo = titulo;
        this.fechaGeneracion = fechaGeneracion;
        this.autor = autor;
        this.transacciones = transacciones;
        this.contenido = contenido;
    }

    @Override
    public String generarReporte() {
        return "=== REPORTE BÁSICO ===\n" +
                "Título: " + titulo + "\n" +
                "Fecha: " + fechaGeneracion + "\n" +
                "Autor: " + autor + "\n" +
                "Contenido: " + contenido + "\n" +
                "Transacciones: " + transacciones.size() + " registros.";
    }
}