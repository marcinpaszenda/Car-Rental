package com.carrental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
