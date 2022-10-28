package com.carrental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

        private Long carId;
        private String carBrand;
        private String registrationNumber;
        private Long carMileage;
        private String vinNumber;
}
