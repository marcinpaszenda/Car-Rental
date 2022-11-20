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
    private Long rentalDayLength;

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

    @Column(name = "IS_ACTIVE_CAR_RENT")
    private boolean isActive;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_RELEASE_REPORT_ID")
    private CarReleaseReport carReleaseReport;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_RETURN_REPORT_ID")
    private CarReturnReport carReturnReport;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

}

