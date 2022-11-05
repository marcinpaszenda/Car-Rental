package com.carrental.controller;

import com.carrental.domain.Car;
import com.carrental.domain.dto.CarDto;
import com.carrental.mapper.CarMapper;
import com.carrental.service.CarService;
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

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @MockBean
    private CarMapper carMapper;

    @Test
    void shouldFetchEmptyCarList() throws Exception {
        //Given
        when(carService.getAllCars()).thenReturn(List.of());
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldGetAllCars() throws Exception {
        //Given
        List<CarDto> carDtoList = List.of(new CarDto(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage"));
        List<Car> carList = List.of(new Car(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage"));

        when(carService.getAllCars()).thenReturn(carList);
        when(carMapper.mapToCarDtoList(carList)).thenReturn(carDtoList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].carId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].carBrand", Matchers.is("Mercedes G")));
    }

    @Test
    void shouldGetCar() throws Exception {
        //Given
        Car car = new Car(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage");
        CarDto carDto = new CarDto(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage");

        when(carService.findCarById(1L)).thenReturn(car);
        when(carMapper.mapToCarDto(car)).thenReturn(carDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/cars/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.carId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.carBrand", Matchers.is("Mercedes G")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.registrationNumber", Matchers.is("WE44433")));
    }

    @Test
    void shouldCreateCar() throws Exception {
        //Given
        Car car = new Car(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage");
        CarDto carDto = new CarDto(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage");

        when(carMapper.mapToCar(carDto)).thenReturn(car);
        when(carService.saveCar(car)).thenReturn(car);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(car);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    void shouldUpdateCar() throws Exception {
        //Given
        Car car = new Car(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage");
        CarDto carDto = new CarDto(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage");
        Car updatedCar = new Car(2L, "Mercedes G", "SK22009", 45000L, "VIN6542234", "broken window");
        CarDto updatedCarDto = new CarDto(2L, "Mercedes G", "SK22009", 45000L, "VIN6542234", "broken window");

        when(carMapper.mapToCar(carDto)).thenReturn(car);
        when(carService.saveCar(car)).thenReturn(updatedCar);
        when(carMapper.mapToCarDto(any())).thenReturn(updatedCarDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(updatedCarDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.carId", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.registrationNumber", Matchers.is("SK22009")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.carDamage", Matchers.is("broken window")));
    }

    @Test
    void shouldDeleteCar() throws Exception {
        //Given & When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/cars/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
