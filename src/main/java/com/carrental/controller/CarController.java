package com.carrental.controller;

import com.carrental.domain.Car;
import com.carrental.domain.dto.CarDto;
import com.carrental.exceptions.CarNotFoundException;
import com.carrental.mapper.CarMapper;
import com.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping
    public ResponseEntity<List<CarDto>> getCars() throws CarNotFoundException {
        List<Car> cars = carService.getAllCars();
        carService.carStatus();
        return ResponseEntity.ok(carMapper.mapToCarDtoList(cars));
    }

    @GetMapping(value = "{carId}")
    public ResponseEntity<CarDto> getCar(@PathVariable Long carId) throws CarNotFoundException {
        return ResponseEntity.ok(carMapper.mapToCarDto(carService.findCarById(carId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> addCar(@RequestBody CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(car);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto carDto) throws CarNotFoundException {
        Car car = carMapper.mapToCar(carDto);
        Car updatedCar = carService.updateCar(car);
        return ResponseEntity.ok().body(carMapper.mapToCarDto(updatedCar));
    }

    @DeleteMapping(value = "{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) throws CarNotFoundException {
        carService.deleteCar(carId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
