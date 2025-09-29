package edu.dosw.taller.DOSW_TALLER_2.model;

import edu.dosw.taller.DOSW_TALLER_2.repository.ReporteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReporteRepositoryTest {

    @Autowired
    private ReporteRepository reporteRepository;

    @BeforeEach
    void limpiarBD() {
        reporteRepository.deleteAll();
    }

    @Test
    void guardarYLeerUnReporte() {
        Transaccion t = new Transaccion("1", "Compra", BigDecimal.valueOf(100), LocalDate.now(), "Alimentos");

        ReporteDocument reporte = new ReporteDocument();
        reporte.setTitulo("Test");
        reporte.setFechaGeneracion(LocalDate.now());
        reporte.setAutor("Carlos");
        reporte.setTransacciones(List.of(t));
        reporte.setContenido("Contenido de prueba");
        reporte.setContenidoFinal("Final");

        ReporteDocument guardado = reporteRepository.save(reporte);

        ReporteDocument encontrado = reporteRepository.findById(guardado.getId()).orElse(null);

        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getTitulo()).isEqualTo("Test");
        assertThat(encontrado.getAutor()).isEqualTo("Carlos");
        assertThat(encontrado.getTransacciones()).hasSize(1);
    }

    @Test
    void guardarVariosReportesYConsultarTodos() {
        LocalDate hoy = LocalDate.now();

        ReporteDocument r1 = new ReporteDocument();
        r1.setTitulo("Reporte Alimentos");
        r1.setFechaGeneracion(hoy);
        r1.setAutor("Carlos");
        r1.setTransacciones(List.of(
                new Transaccion("1", "Compra", BigDecimal.valueOf(100), hoy, "Alimentos")
        ));
        r1.setContenido("Compra de comida");
        r1.setContenidoFinal("OK");

        ReporteDocument r2 = new ReporteDocument();
        r2.setTitulo("Reporte Ventas");
        r2.setFechaGeneracion(hoy);
        r2.setAutor("Ana");
        r2.setTransacciones(List.of(
                new Transaccion("2", "Venta", BigDecimal.valueOf(250), hoy, "Electrónica"),
                new Transaccion("3", "Pago", BigDecimal.valueOf(50), hoy, "Servicios")
        ));
        r2.setContenido("Ventas varias");
        r2.setContenidoFinal("OK");

        reporteRepository.saveAll(List.of(r1, r2));

        List<ReporteDocument> todos = reporteRepository.findAll();

        assertThat(todos).hasSize(2);
        assertThat(todos.get(0).getTransacciones()).isNotEmpty();
        assertThat(todos.get(1).getTransacciones()).hasSize(2);
    }

    @Test
    void buscarPorAutor() {
        LocalDate hoy = LocalDate.now();

        ReporteDocument reporte = new ReporteDocument();
        reporte.setTitulo("Compras de ropa");
        reporte.setFechaGeneracion(hoy);
        reporte.setAutor("Luis");
        reporte.setTransacciones(List.of(
                new Transaccion("10", "Compra", BigDecimal.valueOf(300), hoy, "Ropa")
        ));
        reporte.setContenido("Gastos en ropa");
        reporte.setContenidoFinal("Resumen OK");

        reporteRepository.save(reporte);

        List<ReporteDocument> encontrados = reporteRepository.findByAutor("Luis");

        assertThat(encontrados).isNotEmpty();
        assertThat(encontrados.get(0).getTitulo()).isEqualTo("Compras de ropa");
    }

    @Test
    void buscarPorFechaGeneracion() {
        LocalDate fechaHist = LocalDate.of(2025, 9, 28);  // Fecha fija
        LocalDate fechaOtra = fechaHist.plusDays(1);      // Fecha distinta

        ReporteDocument reporte1 = new ReporteDocument();
        reporte1.setTitulo("Reporte histórico");
        reporte1.setFechaGeneracion(fechaHist);
        reporte1.setAutor("Ana");
        reporte1.setTransacciones(List.of(
                new Transaccion("20", "Compra", BigDecimal.valueOf(150), fechaHist, "Libros")
        ));
        reporte1.setContenido("Lectura y cultura");
        reporte1.setContenidoFinal("OK");

        ReporteDocument reporte2 = new ReporteDocument();
        reporte2.setTitulo("Reporte distinto");
        reporte2.setFechaGeneracion(fechaOtra); // 👈 otra fecha
        reporte2.setAutor("Carlos");
        reporte2.setTransacciones(List.of(
                new Transaccion("21", "Pago", BigDecimal.valueOf(75), fechaOtra, "Servicios")
        ));
        reporte2.setContenido("Servicios públicos");
        reporte2.setContenidoFinal("OK");

        reporteRepository.saveAll(List.of(reporte1, reporte2));

        // Buscar solo por la fechaHist
        List<ReporteDocument> encontrados = reporteRepository.findByFechaGeneracion(fechaHist);

        assertThat(encontrados).hasSize(1);
        assertThat(encontrados.get(0).getTitulo()).isEqualTo("Reporte histórico");
        assertThat(encontrados.get(0).getAutor()).isEqualTo("Ana");
    }
}
