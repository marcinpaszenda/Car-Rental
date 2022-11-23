package com.carrental.service;

import com.carrental.domain.CarRent;
import com.carrental.domain.Client;
import com.carrental.domain.Driver;
import com.carrental.exceptions.DriverNotFoundException;
import com.carrental.repository.DriverRepository;
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
public class DriverServiceTest {

    @InjectMocks
    private DriverService driverService;

    @Mock
    DriverRepository driverRepository;

    @Test
    void getAllDriversTest() {
        //Given
        List<CarRent> carRents = new ArrayList<>();
        Client client = new Client();
        List<Driver> driverList = new ArrayList<>();

        Driver driver1 = new Driver(5L, "Thomas Smith", "444/3445/RE/3",
                "33/FE/5655", "799330432", client, carRents);

        Driver driver2 = new Driver(6L, "Arthur Bart", "4MN/09876/P",
                "2094/FE4/231", "789232000", client, carRents);

        driverList.add(driver1);
        driverList.add(driver2);
        when(driverRepository.findAll()).thenReturn(driverList);
        //When
        List<Driver> resultList = driverService.getAllDrivers();
        //Then
        assertEquals(2, resultList.size());
    }

    @Test
    void getDriverTest() throws DriverNotFoundException {
        //Given
        List<CarRent> carRents = new ArrayList<>();
        Client client = new Client();

        Driver driver1 = new Driver(5L, "Thomas Smith", "444/3445/RE/3",
                "33/FE/5655", "799330432", client, carRents);

        when(driverRepository.findById(5L)).thenReturn(Optional.of(driver1));
        //When
        Driver result = driverService.findDriverById(5L);
        //Then
        assertEquals(driver1, result);
    }

    @Test
    void saveDriverTest() throws DriverNotFoundException {
        //Given
        List<CarRent> carRents = new ArrayList<>();
        Client client = new Client();

        Driver driver1 = new Driver(5L, "Thomas Smith", "444/3445/RE/3",
                "33/FE/5655", "799330432", client, carRents);

        when(driverRepository.findById(5L)).thenReturn(Optional.of(driver1));
        //When
        Driver updateDriver = driverService.findDriverById(5L);
        updateDriver.setDriverName("John Smith");
        driverService.saveDriver(updateDriver);
        //Then
        assertEquals("John Smith", updateDriver.getDriverName());
    }
}
