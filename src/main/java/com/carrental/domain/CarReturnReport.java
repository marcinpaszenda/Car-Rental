package com.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CAR_RETURN_REPORT")
public class CarReturnReport {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CAR_RETURN_REPORT_ID")
    private Long carReturnReportId;

    @Column(name = "CLEAN_CAR_BODY")
    private boolean cleanCarBody;

    @Column(name = "CLEAN_CAR_INTERIOR")
    private boolean cleanCarInterior;

    @Column(name = "AMOUNT_OF_FUEL_PER_CENT")
    private int amountOfFuel;

    @Column(name = "CAR_MILEAGE")
    private Long carMileage;

    @Column(name = "NEW_CAR_DAMAGE")
    private String newCarDamage;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "DEPOSIT_REFUND")
    private BigDecimal depositRefund;
}