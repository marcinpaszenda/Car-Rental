package com.carrental.domain.dto;

import com.carrental.domain.CarRent;
import com.carrental.domain.Driver;
import com.carrental.domain.TypeOfIdentificationNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long clientId;
    private String name;
    private String street;
    private Long streetNumber;
    private String postalCode;
    private String city;
    private String country;
    private String placeOfBirth;
    private TypeOfIdentificationNumber typeOfIdentificationNumber;
    private Long identificationNumber;
    private Long phoneNumber;
    private String email;
    private List<Driver> drivers;
    private List<CarRent> carRents;
}
