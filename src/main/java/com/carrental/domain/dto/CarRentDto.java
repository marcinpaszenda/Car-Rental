package com.carrental.domain.dto;

import com.carrental.domain.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarRentDto {

    private Long carRentId;
    private LocalDate rentalDate;
    private LocalTime rentalHour;
    private LocalDate returnDate;
    private LocalTime returnHour;
    private Long rentalDayLength;
    private Currency currency;
    private BigDecimal dailyRate;
    private BigDecimal additionalCosts;
    private BigDecimal deposit;
    private BigDecimal totalCost;
    private boolean dailyMileageLimit;
    private boolean travelAbroad;
    private boolean registrationCertificate;
    private boolean abolitionDeductibleInDamage;
    private BigDecimal abolitionFee;
    private Car car;
    private Driver driver;
    private Client client;
    private CarReleaseReport carReleaseReport;
    private CarReturnReport carReturnReport;
}
