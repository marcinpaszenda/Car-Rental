package com.carrental.service;

import com.carrental.domain.Car;
import com.carrental.domain.CarRent;
import com.carrental.exceptions.CarNotFoundException;
import com.carrental.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    CarRepository carRepository;

    @Test
    void getAllCarsTest() {
        //Given
        List<CarRent> carRents = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car(1L, "Opel Mokka", "SK1120P", 25000L, "VIN549202MN1", "no damage", carRents);
        Car car2 = new Car(2L, "Opel Corsa", "SK59482", 66000L, "VIN4939/F432/2", "scratch on door", carRents);
        carList.add(car1);
        carList.add(car2);
        when(carRepository.findAll()).thenReturn(carList);
        //When
        List<Car> resultList = carService.getAllCars();
        //Then
        assertEquals(2, resultList.size());
    }

    @Test
    void getCarTest() throws CarNotFoundException {
        //Given
        List<CarRent> carRents = new ArrayList<>();
        Car car1 = new Car(1L, "Opel Mokka", "SK1120P", 25000L, "VIN549202MN1", "no damage", carRents);
        when(carRepository.findById(1L)).thenReturn(Optional.of(car1));
        //When
        Car result = carService.findCarById(1L);
        //Then
        assertEquals(car1, result);
    }

    @Test
    void saveCarTest() throws CarNotFoundException {
        //Given
        List<CarRent> carRents = new ArrayList<>();
        Car car1 = new Car(1L, "Opel Mokka", "SK1120P", 25000L, "VIN549202MN1", "no damage", carRents);
        when(carRepository.findById(1L)).thenReturn(Optional.of(car1));
        //When
        Car updateCar = carService.findCarById(1L);
        updateCar.setCarBrand("Opel Astra");
        carService.saveCar(updateCar);
        //Then
        assertEquals("Opel Astra", updateCar.getCarBrand());
    }
}
