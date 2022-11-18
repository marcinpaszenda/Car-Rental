package com.carrental.mapper;

import com.carrental.domain.CarRent;
import com.carrental.domain.dto.CarRentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarRentMapper {

    public CarRent mapToCarRent(CarRentDto carRentDto) {
        return CarRent.builder()
                .carRentId(carRentDto.getCarRentId())
                .rentalDate(carRentDto.getRentalDate())
                .returnHour(carRentDto.getRentalHour())
                .returnDate(carRentDto.getReturnDate())
                .returnHour(carRentDto.getReturnHour())
                .rentalDayLength(carRentDto.getRentalDayLength())
                .currency(carRentDto.getCurrency())
                .dailyRate(carRentDto.getDailyRate())
                .additionalCosts(carRentDto.getAdditionalCosts())
                .deposit(carRentDto.getDeposit())
                .totalCost(carRentDto.getTotalCost())
                .dailyMileageLimit(carRentDto.getDailyMileageLimit())
                .travelAbroad(carRentDto.getTravelAbroad())
                .registrationCertificate(carRentDto.getRegistrationCertificate())
                .abolitionDeductibleInDamage(carRentDto.getAbolitionDeductibleInDamage())
                .abolitionFee(carRentDto.getAbolitionFee())
                .car(carRentDto.getCar())
                .driver(carRentDto.getDriver())
                .client(carRentDto.getClient())
                .carReleaseReport(carRentDto.getCarReleaseReport())
                .carReturnReport(carRentDto.getCarReturnReport())
                .build();
    }

    public CarRentDto mapToCarRentDto(CarRent carRent) {
        return new CarRentDto(
        carRent.getCarRentId(),
        carRent.getRentalDate(),
        carRent.getReturnHour(),
        carRent.getReturnDate(),
        carRent.getReturnHour(),
        carRent.getRentalDayLength(),
        carRent.getCurrency(),
        carRent.getDailyRate(),
        carRent.getAdditionalCosts(),
        carRent.getDeposit(),
        carRent.getTotalCost(),
        carRent.getDailyMileageLimit(),
        carRent.getTravelAbroad(),
        carRent.getRegistrationCertificate(),
        carRent.getAbolitionDeductibleInDamage(),
        carRent.getAbolitionFee(),
        carRent.getCar(),
        carRent.getDriver(),
        carRent.getClient(),
        carRent.getCarReleaseReport(),
        carRent.getCarReturnReport()
        );
    }

    public List<CarRentDto> mapToCarRentDtoList(final List<CarRent> carRents)  {
        return carRents.stream()
                .map(this::mapToCarRentDto)
                .collect(Collectors.toList());
    }
}
