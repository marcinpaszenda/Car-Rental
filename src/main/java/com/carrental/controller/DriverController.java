package com.carrental.controller;

import com.carrental.domain.CarRent;
import com.carrental.domain.Client;
import com.carrental.domain.Driver;
import com.carrental.domain.dto.DriverDto;
import com.carrental.exceptions.DriverNotFoundException;
import com.carrental.mapper.DriverMapper;
import com.carrental.repository.CarRentRepository;
import com.carrental.repository.ClientRepository;
import com.carrental.repository.DriverRepository;
import com.carrental.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/drivers")
public class DriverController {

    private final DriverMapper driverMapper;
    private final DriverService driverService;
    private final DriverRepository driverRepository;
    private final ClientRepository clientRepository;


    @GetMapping
    public ResponseEntity<List<DriverDto>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(driverMapper.mapToDriverDtoList(drivers));
    }

    @GetMapping(value = "{driverId}")
    public ResponseEntity<DriverDto> getDriver(@PathVariable Long driverId) throws DriverNotFoundException {
        return ResponseEntity.ok(driverMapper.mapToDriverDto(driverService.findDriverById(driverId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Driver> addDriver(@RequestBody DriverDto driverDto) {
        Driver driver = driverMapper.mapToDriver(driverDto);
        driverService.saveDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(driver);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverDto> updateDriver(@RequestBody DriverDto driverDto) throws DriverNotFoundException {
        Driver driver = driverMapper.mapToDriver(driverDto);
        Driver updatedDriver = driverService.updateDriver(driver);
        return ResponseEntity.ok().body(driverMapper.mapToDriverDto(updatedDriver));
    }

    @DeleteMapping(value = "{driverId}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long driverId) throws DriverNotFoundException {
        driverService.deleteDriver(driverId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{driverId}/clients/{clientId}")
    public Driver assignDriverToClient(@PathVariable Long driverId, @PathVariable Long clientId) {
        Driver driver = driverRepository.findById(driverId).get();
        Client client = clientRepository.findById(clientId).get();
        driver.setClient(client);
        return driverRepository.save(driver);
    }
}
