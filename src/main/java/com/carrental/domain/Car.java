package com.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CAR_ID", unique = true)
    private Long carId;

    @Column(name = "CAR_BRAND")
    private String carBrand;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "CAR_MILEAGE")
    private Long carMileage;

    @Column(name = "VIN_NUMBER")
    private String vinNumber;
}
