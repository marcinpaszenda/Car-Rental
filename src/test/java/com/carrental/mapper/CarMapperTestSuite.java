package com.carrental.mapper;

import com.carrental.domain.Car;
import com.carrental.domain.CarRent;
import com.carrental.domain.dto.CarDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarMapperTestSuite {

    @Test
    void mapToCarTest() {
        //Given
        ArrayList<CarRent> carRents = new ArrayList<>();
        CarMapper carMapper = new CarMapper();
        CarDto carDto = new CarDto(1L, "Mercedes G", "WE44433", 45000L, "VIN6542234", "no damage", carRents);
        //When
        Car car = carMapper.mapToCar(carDto);
        //Then
        assertNotNull(car.getCarId());
        assertEquals("Mercedes G", car.getCarBrand());
    }

    @Test
    void mapToCarDtoTest() {
        //Given
        ArrayList<CarRent> carRents = new ArrayList<>();
        CarMapper carMapper = new CarMapper();
        Car car = new Car(2L, "Honda Civic", "WE11234", 4776L, "VIN3243453634", null, carRents);
        //When
        CarDto carDto = carMapper.mapToCarDto(car);
        //Then
        assertNotNull(carDto.getCarId());
        assertEquals("Honda Civic", carDto.getCarBrand());
    }

    @Test
    void mapToCarDtoListTest() {
        //Given
        ArrayList<CarRent> carRents = new ArrayList<>();
        CarMapper carMapper = new CarMapper();
        Car car = new Car(2L, "Honda Civic", "WE11234", 4776L, "VIN3243453634", null, carRents);
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        //When
        List<CarDto> carDtoList = carMapper.mapToCarDtoList(carList);
        //Then
        assertNotNull(carDtoList.get(0).getCarId());
        assertEquals(1, carDtoList.size());
        assertEquals("WE11234", carDtoList.get(0).getRegistrationNumber());
    }
}
