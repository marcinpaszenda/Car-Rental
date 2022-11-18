package com.carrental.domain.dto;

import com.carrental.domain.enums.CleanCarBody;
import com.carrental.domain.enums.CleanCarInterior;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarReturnReportDto {

    private Long carReturnReportId;
    private CleanCarBody cleanCarBody;
    private CleanCarInterior cleanCarInterior;
    private int amountOfFuel;
    private Long carMileage;
    private String newCarDamage;
    private String remarks;
    private BigDecimal depositRefund;
}
