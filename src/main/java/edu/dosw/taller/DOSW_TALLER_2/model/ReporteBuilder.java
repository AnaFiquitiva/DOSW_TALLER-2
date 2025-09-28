package edu.dosw.taller.DOSW_TALLER_2.model;

import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
public class ReporteBuilder {
    private String titulo;
    private LocalDate fechaGeneracion;
    private String autor;
    private List<Transaccion> transacciones = new ArrayList<>();
    private String contenido;

    public ReporteBuilder conTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ReporteBuilder conFechaGeneracion(LocalDate fecha) {
        this.fechaGeneracion = fecha;
        return this;
    }

    public ReporteBuilder conAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public ReporteBuilder conTransaccion(Transaccion t) {
        this.transacciones.add(t);
        return this;
    }

    public ReporteBuilder conContenido(String contenido) {
        this.contenido = contenido;
        return this;
    }

    public ReporteBasico build() {
        if (titulo == null || autor == null || contenido == null || transacciones.isEmpty()) {
            throw new IllegalStateException("Faltan campos obligatorios: título, autor, contenido o transacciones.");
        }
        return new ReporteBasico(titulo, fechaGeneracion, autor, transacciones, contenido);
    }
}