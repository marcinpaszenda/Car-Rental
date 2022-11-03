package com.carrental.mapper;

import com.carrental.domain.Driver;
import com.carrental.domain.dto.DriverDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DriverMapperTestSuite {

    @Test
    void mapToDriverTest() {
        //Given
        DriverMapper driverMapper = new DriverMapper();
        DriverDto driverDto = new DriverDto(5L, "Thomas Smith", "444/3445/RE/3", "33/FE/5655", 799330432L);
        //When
        Driver driver = driverMapper.mapToDriver(driverDto);
        //Then
        assertNotNull(driver.getDriverId());
        assertEquals("Thomas Smith", driver.getDriverName());
    }

    @Test
    void mapToDriverDtoTest() {
        //Given
        DriverMapper driverMapper = new DriverMapper();
        Driver driver = new Driver(5L, "Thomas Smith", "444/3445/RE/3", "33/FE/5655", 799330432L, null);
        //When
        DriverDto driverDto = driverMapper.mapToDriverDto(driver);
        //Then
        assertNotNull(driverDto.getDriverId());
        assertEquals("444/3445/RE/3", driverDto.getIdentityCardNumber());
    }

    @Test
    void mapToDriverDtoListTest() {
        //Given
        DriverMapper driverMapper = new DriverMapper();
        List<Driver> driverList = new ArrayList<>();
        Driver driver1 = new Driver(5L, "Thomas Smith", "444/3445/RE/3", "33/FE/5655", 799330432L, null);
        Driver driver2 = new Driver(6L, "Arthur Bart", "4MN/09876/P", "2094/FE4/231", 789232000L, null);
        driverList.add(driver1);
        driverList.add(driver2);
        //When
        List<DriverDto> driverDtoList = driverMapper.mapToDriverDtoList(driverList);
        //Then
        assertNotNull(driverDtoList.get(1).getDriverId());
        assertEquals(799330432L, driverDtoList.get(0).getPhoneNumber());
        assertEquals(6L, driverDtoList.get(1).getDriverId());
        assertEquals(2, driverDtoList.size());
    }
}
