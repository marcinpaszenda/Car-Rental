package com.carrental.domain;

import com.carrental.domain.enums.TypeOfIdentificationNumber;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
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

    @Column(name = "STREET")
    private String street;

    @Column(name = "STREET_NUMBER")
    private String streetNumber;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PLACE_OF_BIRTH")
    private String placeOfBirth;

    @Column(name = "TYPE_OF_ID_NUMBER")
    private TypeOfIdentificationNumber typeOfIdentificationNumber;

    @Column(name = "IDENTIFICATION_NUMBER")
    private String identificationNumber;

    @Column(name = "IDENTITY_CARD_NUMBER")
    private String identityCardNumber;

    @Column(name = "DRIVING_LICENSE_NUMBER")
    private String drivingLicenseNumber;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

        @JsonIgnore
    @OneToMany(
            targetEntity = Driver.class,
            mappedBy = "client",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    public List<Driver> drivers;

    @JsonIgnore
    @OneToMany(
            targetEntity = CarRent.class,
            mappedBy = "client",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    public List<CarRent> carRents;

}
