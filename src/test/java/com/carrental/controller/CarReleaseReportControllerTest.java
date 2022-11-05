package com.carrental.controller;

import com.carrental.domain.CarReleaseReport;
import com.carrental.domain.dto.CarReleaseReportDto;
import com.carrental.mapper.CarReleaseReportMapper;
import com.carrental.service.CarReleaseReportService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(CarReleaseReportController.class)
public class CarReleaseReportControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CarReleaseReportService service;

    @MockBean
    private CarReleaseReportMapper mapper;

    @Test
    void shouldGetCarReleaseReport() throws Exception {
        //Given
        CarReleaseReport carReleaseReport = new CarReleaseReport(1L, true, true, 100, 34500L, null);
        CarReleaseReportDto carReleaseReportDto = new CarReleaseReportDto(1L, true, true, 100, 34500L, null);

        when(service.findCarReleaseReportById(1L)).thenReturn(carReleaseReport);
        when(mapper.mapToCarReleaseReportDto(carReleaseReport)).thenReturn(carReleaseReportDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/carReleaseReport/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.carReleaseReportId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.carMileage", Matchers.is(34500)));
    }

    @Test
    void shouldCreateCarReleaseReport() throws Exception {
        //Given
        CarReleaseReport carReleaseReport = new CarReleaseReport(1L, true, true, 100, 34500L, null);
        CarReleaseReportDto carReleaseReportDto = new CarReleaseReportDto(1L, true, true, 100, 34500L, null);

        when(mapper.mapToCarReleaseReport(carReleaseReportDto)).thenReturn(carReleaseReport);
        when(service.saveCarReleaseReport(carReleaseReport)).thenReturn(carReleaseReport);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(carReleaseReport);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/carReleaseReport")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    void shouldUpdateCarReleaseReport() throws Exception {
        //Given
        CarReleaseReport carReleaseReport = new CarReleaseReport(1L, true, true, 100, 34500L, "ok");
        CarReleaseReportDto carReleaseReportDto = new CarReleaseReportDto(1L, true, true, 100, 34500L, "ok");
        CarReleaseReport updateCarReleaseReport = new CarReleaseReport(2L, false, true, 100, 40000L, "ok");
        CarReleaseReportDto updateCarReleaseReportDto = new CarReleaseReportDto(2L, false, true, 100, 40000L, "ok");

        when(mapper.mapToCarReleaseReport(carReleaseReportDto)).thenReturn(carReleaseReport);
        when(service.updateCarReleaseReport(carReleaseReport)).thenReturn(updateCarReleaseReport);
        when(mapper.mapToCarReleaseReportDto(any())).thenReturn(updateCarReleaseReportDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(updateCarReleaseReportDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/carReleaseReport")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.carReleaseReportId", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.carMileage", Matchers.is(40000)));
    }

    @Test
    void shouldDeleteCarReleaseReport() throws Exception {
        //Given & When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/carReleaseReport/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

}
