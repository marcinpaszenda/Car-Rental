package com.carrental.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CAR_RELEASE_REPORT")
public class CarReleaseReport {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CAR_RELEASE_REPORT_ID")
    private Long carReleaseReportId;

    @Column(name = "CLEAN_CAR_BODY")
    private boolean cleanCarBody;

    @Column(name = "CLEAN_CAR_INTERIOR")
    private boolean cleanCarInterior;

    @Column(name = "AMOUNT_OF_FUEL_PER_CENT")
    private int amountOfFuel;

    @Column(name = "CAR_MILEAGE")
    private Long carMileage;

    @Column(name = "REMARKS")
    private String remarks;
}
