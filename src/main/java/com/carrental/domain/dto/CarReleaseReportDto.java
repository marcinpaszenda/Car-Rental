package com.carrental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarReleaseReportDto {

    private Long carReleaseReportId;
    private boolean cleanCarBody;
    private boolean cleanCarInterior;
    private int amountOfFuel;
    private Long carMileage;
    private String carDamage;
    private String remarks;
}
