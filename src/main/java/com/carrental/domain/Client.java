package com.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "CLIENT_ID", unique = true)
    private Long clientId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PLACE_OF_BIRTH")
    private String placeOfBirth;

    @Column(name = "TYPE_OF_ID_NUMBER")
    private TypeOfIdentificationNumber typeOfIdentificationNumber;

    @Column(name = "IDENTIFICATION_NUMBER")
    private Long identificationNumber;

    @OneToMany(
            targetEntity = CarRent.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<CarRent> carRents = new ArrayList<>();

    @OneToMany(
            targetEntity = Driver.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Driver> drivers = new ArrayList<>();
}
