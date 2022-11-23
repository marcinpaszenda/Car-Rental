package com.carrental.repository;

import com.carrental.domain.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DriverRepositoryTestSuite {

    @Autowired
    private DriverRepository driverRepository;
    private Driver driver;

    @BeforeEach
    public void beforeTests() {
        driver = Driver.builder()
                .driverName("John Smith")
                .identityCardNumber("444/T55/E")
                .drivingLicenseNumber("223302/W/11")
                .phoneNumber("505333222")
                .build();
    }

    @Test
    public void saveDriverTest() {
        //Given
        //When
        driverRepository.save(driver);
        //Then
        assertTrue(driverRepository.existsById(driver.getDriverId()));
        assertEquals("John Smith", driver.getDriverName());
        //CleanUp
        driverRepository.deleteById(driver.getDriverId());
    }

    @Test
    public void findDriverByIdTest() {
        //Given
        driverRepository.save(driver);
        String IdCardNumber = "444/T55/E";
        //When
        Driver result = driverRepository.findById(driver.getDriverId()).get();
        //Then
        assertEquals("223302/W/11", result.getDrivingLicenseNumber());
        assertEquals(IdCardNumber, result.getIdentityCardNumber());
        //CleanUp
        driverRepository.deleteById(driver.getDriverId());
    }

    @Test
    public void deleteDriverByIdTest() {
        //Given
        driverRepository.save(driver);
        //When
        driverRepository.deleteById(driver.getDriverId());
        //Then
        assertEquals(Optional.empty(), driverRepository.findById(driver.getDriverId()));
    }
}
