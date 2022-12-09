package com.carrental.domain.dto;

import com.carrental.domain.CarRent;
import com.carrental.domain.enums.CarStatus;
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
        private String car;
        private String carBrand;
        private String registrationNumber;
        private Long carMileage;
        private CarStatus carStatus;
        private String carDamage;
        private List<CarRent> carRentList;
}
