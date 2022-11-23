package com.carrental.controller;

import com.carrental.domain.*;
import com.carrental.domain.dto.CarRentDto;
import com.carrental.exceptions.*;
import com.carrental.mapper.CarRentMapper;
import com.carrental.repository.*;
import com.carrental.service.CarRentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/carRents")
public class CarRentController {

    private final CarRentMapper carRentMapper;
    private final CarRentService carRentService;
    private final CarRentRepository carRentRepository;
    private final DriverRepository driverRepository;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<CarRentDto>> getCarRents() {
        List<CarRent> carRents = carRentService.getAllCarRents();
        return ResponseEntity.ok(carRentMapper.mapToCarRentDtoList(carRents));
    }

    @GetMapping(value = "{carRentId}")
    public ResponseEntity<CarRentDto> getCarRent(@PathVariable Long carRentId) throws CarRentNotFoundException {
        return ResponseEntity.ok(carRentMapper.mapToCarRentDto(carRentService.findCarRentById(carRentId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarRent> addCarRent(@RequestBody CarRentDto carRentDto) throws CarNotFoundException {
        CarRent carRent = carRentMapper.mapToCarRent(carRentDto);
        carRentService.saveCarRent(carRent);

        //dodajemy aktualny przebieg pojazdu przed wydaniem
        Long carRentId = carRent.getCarRentId();
        Long newCarMileageRelase = carRent.getCarMileageRelease();
        carRentService.updateCarMileage(carRentId, newCarMileageRelase);
        //dodajemy aktualny przebieg pojazdu po zwrocie
        Long newCarMileageReturn = carRent.getCarMileageReturn();
        carRentService.updateCarMileage(carRentId, newCarMileageReturn);
        // dodajemy ewentualne nowe uszkodzenia do car
        String newDamage = carRent.getNewCarDamage();
        carRentService.addNewDamageToCar(carRentId, newDamage);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carRent);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarRentDto> updateCarRent(@RequestBody CarRentDto carRentDto) throws CarRentNotFoundException, CarNotFoundException {
        CarRent carRent = carRentMapper.mapToCarRent(carRentDto);
        CarRent updatedCarRent = carRentService.updateCarRent(carRent);
        //dodajemy aktualny przebieg pojazdu po zwrocie
        Long carRentId = carRent.getCarRentId();
        Long newCarMileage = carRent.getCarMileageReturn();
        carRentService.updateCarMileage(carRentId, newCarMileage);
        // dodajemy ewentualne nowe uszkodzenia do car
        String newDamage = carRent.getNewCarDamage();
        carRentService.addNewDamageToCar(carRentId, newDamage);
        return ResponseEntity.ok().body(carRentMapper.mapToCarRentDto(updatedCarRent));
    }

    @DeleteMapping(value = "{carRentId}")
    public ResponseEntity<Void> deleteCarRent(@PathVariable Long carRentId) throws CarRentNotFoundException {
        carRentService.deleteCarRent(carRentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{carRentId}/drivers/{driverId}")
    public Driver assignDriverToCarRent(@PathVariable Long carRentId, @PathVariable Long driverId) {
        CarRent carRent = carRentRepository.findById(carRentId).get();
        Driver driver = driverRepository.findById(driverId).get();
        carRent.setDriver(driver);
        return carRentRepository.save(carRent).getDriver();
    }

    @PutMapping("{carRentId}/cars/{carId}")
    public Car assignCarToCarRent(@PathVariable Long carRentId, @PathVariable Long carId) throws CarNotFoundException {
        CarRent carRent = carRentRepository.findById(carRentId).get();
        Car car = carRepository.findById(carId).get();
        carRent.setCar(car);
        //dodajemy aktualny przebieg pojazdu przed wydaniem
        Long newCarMileage = carRent.getCarMileageRelease();
        carRentService.updateCarMileage(carRentId, newCarMileage);
        return carRentRepository.save(carRent).getCar();
    }

    @PutMapping("{carRentId}/clients/{clientId}")
    public Client assignClientToCarRent(@PathVariable Long carRentId, @PathVariable Long clientId) {
        CarRent carRent = carRentRepository.findById(carRentId).get();
        Client client = clientRepository.findById(clientId).get();
        carRent.setClient(client);
        return carRentRepository.save(carRent).getClient();
    }
}
