package com.carrental.domain.dto;

import com.carrental.domain.CarRent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
        private String carDamage;
        private List<CarRent> carRentList;
}
