package edu.dosw.taller.DOSW_TALLER_2.service.impl;
import edu.dosw.taller.DOSW_TALLER_2.model.*;
import edu.dosw.taller.DOSW_TALLER_2.repository.ReporteRepository;
import edu.dosw.taller.DOSW_TALLER_2.service.interfaces.ReporteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;

    public ReporteServiceImpl(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    @Override
    public String crearReporte(
            String titulo,
            String autor,
            String contenido,
            List<Transaccion> transacciones,
            boolean conGraficas,
            boolean conMarcaAgua,
            boolean conResumen,
            boolean exportable) {

        if (transacciones == null || transacciones.isEmpty()) {
            throw new IllegalArgumentException("La lista de transacciones no puede estar vacía.");
        }

        ReporteBuilder builder = new ReporteBuilder()
                .conTitulo(titulo)
                .conAutor(autor)
                .conContenido(contenido)
                .conFechaGeneracion(LocalDate.now());

        transacciones.forEach(builder::conTransaccion);
        ReporteBasico reporteBasico = builder.build();

        Reporte reporteDecorado = reporteBasico;

        if (conMarcaAgua) {
            reporteDecorado = new ReporteConMarcaAgua(reporteDecorado);
        }
        if (conResumen) {
            reporteDecorado = new ReporteConResumen(reporteDecorado);
        }
        if (conGraficas) {
            reporteDecorado = new ReporteConGraficas(reporteDecorado);
        }
        if (exportable) {
            reporteDecorado = new ReporteExportable(reporteDecorado);
        }

        String contenidoFinal = reporteDecorado.generarReporte();

        // Crear documento MongoDB
        ReporteDocument documento = new ReporteDocument();
        documento.setTitulo(reporteDecorado.getTitulo());
        documento.setFechaGeneracion(reporteDecorado.getFechaGeneracion());
        documento.setAutor(reporteDecorado.getAutor());
        documento.setTransacciones(reporteDecorado.getTransacciones());
        documento.setContenido(reporteDecorado.getContenido());
        documento.setContenidoFinal(contenidoFinal);

        ReporteDocument guardado = reporteRepository.save(documento);

        return guardado.getId();
    }

    @Override
    public List<ReporteDocument> obtenerTodos() {
        return reporteRepository.findAll();
    }

    @Override
    public List<ReporteDocument> filtrarPorFecha(LocalDate fecha) {
        return reporteRepository.findAll().stream()
                .filter(r -> r.getFechaGeneracion().equals(fecha))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReporteDocument> filtrarPorAutor(String autor) {
        return reporteRepository.findAll().stream()
                .filter(r -> r.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReporteDocument> filtrarPorContenido(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            return reporteRepository.findAll();
        }
        String busqueda = tipo.toLowerCase().trim();
        return reporteRepository.findAll().stream()
                .filter(r -> r.getContenido().toLowerCase().contains(busqueda))
                .collect(Collectors.toList());
    }
}
