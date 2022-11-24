package com.carrental.domain.dto;

import com.carrental.domain.*;
import com.carrental.domain.enums.*;
import lombok.*;

import javax.persistence.Column;
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
    private int rentalDayLength;
    private Currency currency;
    private BigDecimal dailyRate;
    private BigDecimal additionalCosts;
    private BigDecimal deposit;
    private BigDecimal totalCost;
    private DailyMileageLimit dailyMileageLimit;
    private TravelAbroad travelAbroad;
    private RegistrationCertificate registrationCertificate;
    private AbolitionDeductibleInDamage abolitionDeductibleInDamage;
    private BigDecimal abolitionFee;

    private CleanCarBody cleanCarBodyRelease;
    private CleanCarInterior cleanCarInteriorRelease;
    private String amountOfFuelRelease;
    private Long carMileageRelease;
    private String remarksRelease;

    private CleanCarBody cleanCarBodyReturn;
    private CleanCarInterior cleanCarInteriorReturn;
    private String amountOfFuelReturn;
    private Long carMileageReturn;
    private String newCarDamage;
    private String remarksReturn;
    private BigDecimal depositRefund;

    private Car car;
    private Driver driver;
    private Client client;


}
