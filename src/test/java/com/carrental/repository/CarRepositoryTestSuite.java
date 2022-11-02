package com.carrental.repository;

import com.carrental.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CarRepositoryTestSuite {

    @Autowired
    private CarRepository carRepository;
    private Car car;

    @BeforeEach
    public void beforeTests() {
        car = Car.builder()
                .carBrand("Volkswagen Polo")
                .registrationNumber("SK88765")
                .carMileage(22500L)
                .vinNumber("54546/VIN/342232")
                .carDamage("ok")
                .build();
    }

    @Test
    public void saveCarTest() {
        //Given
        //When
        carRepository.save(car);
        //Then
        assertTrue(carRepository.existsById(car.getCarId()));
        assertEquals("Volkswagen Polo", car.getCarBrand());
        //CleanUp
        carRepository.deleteById(car.getCarId());
    }

    @Test
    public void findCarByIdTest() {
        //Given
        carRepository.save(car);
        String damage = "ok";
        //When
        Car result = carRepository.findById(car.getCarId()).get();
        //Then
        assertEquals("SK88765", result.getRegistrationNumber());
        assertEquals(damage, result.getCarDamage());
        //CleanUp
        carRepository.deleteById(car.getCarId());
    }

    @Test
    public void deleteCarByIdTest() {
        //Given
        carRepository.save(car);
        //When
        carRepository.deleteById(car.getCarId());
        //Then
        assertEquals(Optional.empty(), carRepository.findById(car.getCarId()));
    }
}
