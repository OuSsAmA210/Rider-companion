package com.rider.companion.controller;

import com.rider.companion.repository.MotorcycleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MotorcycleControllerTest {

    private static final String MOTORCYCLES_URL = "/api/motorcycles";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MotorcycleRepository repository;

    @BeforeEach
    void clearDatabase() {
        repository.deleteAll();
    }

    @Test
    void performsFullCrudLifecycle() throws Exception {
        String createBody = """
                {"brand":"Yamaha","model":"MT-07","year":2024}
                """;

        mockMvc.perform(post(MOTORCYCLES_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.brand").value("Yamaha"));

        long id = repository.findAll().get(0).getId();

        mockMvc.perform(get(MOTORCYCLES_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(id));

        mockMvc.perform(get(MOTORCYCLES_URL + "/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("MT-07"));

        mockMvc.perform(put(MOTORCYCLES_URL + "/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"brand\":\"Yamaha\",\"model\":\"MT-09\",\"year\":2025}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("MT-09"));

        mockMvc.perform(delete(MOTORCYCLES_URL + "/{id}", id))
                .andExpect(status().isNoContent());

        mockMvc.perform(get(MOTORCYCLES_URL + "/{id}", id))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Motorcycle with id " + id + " was not found"));
    }

    @Test
    void rejectsInvalidMotorcycle() throws Exception {
        mockMvc.perform(post(MOTORCYCLES_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"brand\":\"\",\"model\":\"MT-07\",\"year\":1800}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").exists());
    }
}
