package edu.dosw.taller.DOSW_TALLER_2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dosw.taller.DOSW_TALLER_2.controller.dto.CrearReporteDTO;
import edu.dosw.taller.DOSW_TALLER_2.controller.dto.TransaccionDTO;
import edu.dosw.taller.DOSW_TALLER_2.repository.ReporteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReporteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postReporte_deberiaRetornar201() throws Exception {
        CrearReporteDTO dto = new CrearReporteDTO();
        dto.setTitulo("Reporte Test");
        dto.setAutor("Carlos");
        dto.setContenido("Contenido test");
        dto.setConGraficas(true);
        dto.setConMarcaAgua(false);
        dto.setConResumen(true);
        dto.setExportable(true);

        TransaccionDTO t1 = new TransaccionDTO();
        t1.setDescripcion("Compra");
        t1.setMonto(BigDecimal.valueOf(200));
        t1.setFecha(LocalDate.now());
        t1.setCategoria("Alimentos");
        dto.setTransacciones(List.of(t1));

        mockMvc.perform(post("/api/reportes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    void getReportes_deberiaRetornar200() throws Exception {
        mockMvc.perform(get("/api/reportes"))
                .andExpect(status().isOk());
    }

    @Test
    void getReportesPorAutor() throws Exception {
        mockMvc.perform(get("/api/reportes/autor")
                        .param("autor", "Carlos"))
                .andExpect(status().isOk());
    }

    @Test
    void getReportesPorFecha() throws Exception {
        mockMvc.perform(get("/api/reportes/fecha")
                        .param("fecha", LocalDate.now().toString()))
                .andExpect(status().isOk());
    }

    @Test
    void postReporte_listaVacia_deberiaRetornar400() throws Exception {
        CrearReporteDTO dto = new CrearReporteDTO();
        dto.setTitulo("Reporte inválido");
        dto.setAutor("Ana");
        dto.setContenido("Nada");
        dto.setTransacciones(List.of());

        mockMvc.perform(post("/api/reportes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }
}

