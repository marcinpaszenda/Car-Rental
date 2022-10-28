package com.carrental.service;

import com.carrental.domain.Driver;
import com.carrental.exceptions.DriverNotFoundException;
import com.carrental.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver findDriverById(final Long driverId) throws DriverNotFoundException {
        return driverRepository.findById(driverId).orElseThrow(DriverNotFoundException::new);
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(final Driver driver) throws DriverNotFoundException {
        if (driverRepository.existsById(driver.getDriverId())) {
            driverRepository.save(driver);
            return driver;
        } else {
            throw new DriverNotFoundException();
        }
    }

    public void deleteDriver(Long driverId) throws DriverNotFoundException {
        if (driverRepository.existsById(driverId)) {
            driverRepository.deleteById(driverId);
        } else {
            throw new DriverNotFoundException();
        }
    }
}
