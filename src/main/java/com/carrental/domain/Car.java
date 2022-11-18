package com.carrental.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
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

    @Column(name = "CAR_DAMAGE")
    private String carDamage;

    @JsonIgnore
    @OneToMany(
            targetEntity = CarRent.class,
            mappedBy = "car",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    private List<CarRent> carRentList;
}
