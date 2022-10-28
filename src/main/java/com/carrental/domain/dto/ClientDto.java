package com.carrental.domain.dto;

import com.carrental.domain.TypeOfIdentificationNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long clientId;
    private String name;
    private String placeOfBirth;
    private TypeOfIdentificationNumber typeOfIdentificationNumber;
    private Long identificationNumber;
    private Long phoneNumber;
    private String email;
}
