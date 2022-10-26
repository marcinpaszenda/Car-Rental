package com.carrental.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
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
    private boolean dailyMileageLimit;

    @Column(name = "TRAVEL_ABROAD")
    private boolean travelAbroad;

    @Column(name = "REGISTRATION_CERTIFICATE")
    private boolean registrationCertificate;

    @Column(name = "ABOLITION_DEDUCTIBLE_IN_DAMAGE")
    private boolean abolitionDeductibleInDamage;

    @Column(name = "ABOLITION_FEE")
    private BigDecimal abolitionFee;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_RELEASE_REPORT_ID")
    private CarReleaseReport carReleaseReport;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_RETURN_REPORT_ID")
    private CarReturnReport carReturnReport;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

}

