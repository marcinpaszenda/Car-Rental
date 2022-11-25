package com.carrental.mapper;

import com.carrental.domain.Driver;
import com.carrental.domain.dto.DriverDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverMapper {

    public Driver mapToDriver(final DriverDto driverDto) {
        return Driver.builder()
                .driverId(driverDto.getDriverId())
                .driverName(driverDto.getDriverName())
                .identityCardNumber(driverDto.getIdentityCardNumber())
                .drivingLicenseNumber(driverDto.getDrivingLicenseNumber())
                .phoneNumber(driverDto.getPhoneNumber())
                .client(driverDto.getClient())
                .carRents(driverDto.getCarRents())
                .build();
    }

    public DriverDto mapToDriverDto(final Driver driver) {
        return new DriverDto(
                driver.getDriverId(),
                driver.getDriverName(),
                driver.getIdentityCardNumber(),
                driver.getDrivingLicenseNumber(),
                driver.getPhoneNumber(),
                driver.getClient(),
                driver.getCarRents()
        );
    }

    public List<DriverDto> mapToDriverDtoList(final List<Driver> drivers) {
        return drivers.stream()
                .map(this::mapToDriverDto)
                .collect(Collectors.toList());
    }
}
