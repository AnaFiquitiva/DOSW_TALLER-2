package edu.dosw.taller.DOSW_TALLER_2.model;

import edu.dosw.taller.DOSW_TALLER_2.model.ReporteDocument;
import edu.dosw.taller.DOSW_TALLER_2.model.Transaccion;
import edu.dosw.taller.DOSW_TALLER_2.repository.ReporteRepository;
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

    @Test
    void guardarYLeerReporteDocument() {
        // Crear transacción de ejemplo
        Transaccion t = new Transaccion("1", "Compra", BigDecimal.valueOf(100), LocalDate.now(), "Alimentos");

        // Crear reporte
        ReporteDocument reporte = new ReporteDocument();
        reporte.setTitulo("Test");
        reporte.setFechaGeneracion(LocalDate.now());
        reporte.setAutor("Carlos");
        reporte.setTransacciones(List.of(t));
        reporte.setContenido("Contenido de prueba");
        reporte.setContenidoFinal("Final");

        // Guardar en la base de datos
        ReporteDocument guardado = reporteRepository.save(reporte);

        // Buscar por id
        ReporteDocument encontrado = reporteRepository.findById(guardado.getId()).orElse(null);

        // Verificar
        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getTitulo()).isEqualTo("Test");
    }
}
