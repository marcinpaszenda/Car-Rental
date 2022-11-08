package com.carrental.domain.dto;

import com.carrental.domain.CarRent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {

    private Long driverId;
    private String driverName;
    private String identityCardNumber;
    private String drivingLicenseNumber;
    private Long phoneNumber;
    private List<CarRent> carRents;
}
