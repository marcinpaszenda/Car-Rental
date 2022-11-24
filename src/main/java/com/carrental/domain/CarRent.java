package com.carrental.domain;

import com.carrental.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CAR_RENT")
public class CarRent {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CAR_RENT_ID", unique = true)
    private Long carRentId;

    @Column(name = "RENTAL_DATE")
    private LocalDate rentalDate;

    @Column(name = "RENTAL_HOUR")
    private LocalTime rentalHour;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @Column(name = "RETURN_HOUR")
    private LocalTime returnHour;

    @Column(name = "RENTAL_DAY_LENGTH")
    private int rentalDayLength;

    @Column(name = "CURRENCY")
    private Currency currency;

    @Column(name = "DAILY_RATE")
    private BigDecimal dailyRate;

    @Column(name = "ADDITIONAL_COSTS")
    private BigDecimal additionalCosts;

    @Column(name = "DEPOSIT")
    private BigDecimal deposit;

    @Column(name = "TOTAL_COST")
    private BigDecimal totalCost;

    @Column(name = "DAILY_MILEAGE_LIMIT")
    private DailyMileageLimit dailyMileageLimit;

    @Column(name = "TRAVEL_ABROAD")
    private TravelAbroad travelAbroad;

    @Column(name = "REGISTRATION_CERTIFICATE")
    private RegistrationCertificate registrationCertificate;

    @Column(name = "ABOLITION_DEDUCTIBLE_IN_DAMAGE")
    private AbolitionDeductibleInDamage abolitionDeductibleInDamage;

    @Column(name = "ABOLITION_FEE")
    private BigDecimal abolitionFee;


    @Column(name = "CLEAN_CAR_BODY_RELEASE")
    private CleanCarBody cleanCarBodyRelease;

    @Column(name = "CLEAN_CAR_INTERIOR_RELEASE")
    private CleanCarInterior cleanCarInteriorRelease;

    @Column(name = "AMOUNT_OF_FUEL_RELEASE")
    private String amountOfFuelRelease;

    @Column(name = "CAR_MILEAGE_RELEASE")
    private Long carMileageRelease;

    @Column(name = "REMARKS_RELEASE")
    private String remarksRelease;


    @Column(name = "CLEAN_CAR_BODY_RETURN")
    private CleanCarBody cleanCarBodyReturn;

    @Column(name = "CLEAN_CAR_INTERIOR_RETURN")
    private CleanCarInterior cleanCarInteriorReturn;

    @Column(name = "AMOUNT_OF_FUEL_RETURN")
    private String amountOfFuelReturn;

    @Column(name = "CAR_MILEAGE_RETURN")
    private Long carMileageReturn;

    @Column(name = "NEW_CAR_DAMAGE")
    private String newCarDamage;

    @Column(name = "REMARKS_RETURN")
    private String remarksReturn;

    @Column(name = "DEPOSIT_REFUND")
    private BigDecimal depositRefund;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

}

