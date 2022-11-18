package com.carrental.domain.dto;

import com.carrental.domain.enums.CleanCarBody;
import com.carrental.domain.enums.CleanCarInterior;
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
    private CleanCarBody cleanCarBody;
    private CleanCarInterior cleanCarInterior;
    private int amountOfFuel;
    private Long carMileage;
    private String remarks;
}
