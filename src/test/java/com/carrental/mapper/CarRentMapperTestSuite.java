package com.carrental.mapper;

import com.carrental.domain.CarRent;
import com.carrental.domain.enums.*;
import com.carrental.domain.dto.CarRentDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarRentMapperTestSuite {

    @Test
    void mapToCarRentTest() {
        //Given
        CarRentMapper carRentMapper = new CarRentMapper();
        CarRentDto carRentDto = CarRentDto.builder()
                .carRentId(1L)
                .rentalDate(LocalDate.of(2022, 3, 2))
                .rentalHour(LocalTime.of(10, 10))
                .returnDate(LocalDate.of(2022, 3, 12))
                .returnHour(LocalTime.of(20, 20))
                .rentalDayLength(10)
                .currency(Currency.PLN)
                .dailyRate(BigDecimal.valueOf(100))
                .additionalCosts(BigDecimal.ZERO)
                .deposit(BigDecimal.ZERO)
                .totalCost(BigDecimal.ZERO)
                .dailyMileageLimit(DailyMileageLimit.NIE)
                .travelAbroad(TravelAbroad.NIE)
                .registrationCertificate(RegistrationCertificate.NIE)
                .abolitionDeductibleInDamage(AbolitionDeductibleInDamage.NIE)
                .abolitionFee(BigDecimal.ZERO)
                .isActive(false)
                .cleanCarBodyRelease(CleanCarBody.NIE)
                .cleanCarInteriorRelease(CleanCarInterior.NIE)
                .amountOfFuelRelease("PEŁNY")
                .carMileageRelease(50000L)
                .remarksRelease(null)
                .cleanCarBodyReturn(CleanCarBody.NIE)
                .cleanCarInteriorReturn(CleanCarInterior.NIE)
                .amountOfFuelReturn("PEŁNY")
                .carMileageReturn(55000L)
                .newCarDamage(null)
                .remarksReturn(null)
                .depositRefund(BigDecimal.ZERO)
                .build();

        //When
        CarRent carRent = carRentMapper.mapToCarRent(carRentDto);
        //Then
        assertNotNull(carRent.getCarRentId());
        assertEquals(LocalDate.of(2022, 3, 2), carRent.getRentalDate());
        assertEquals(BigDecimal.valueOf(100), carRent.getDailyRate());
    }

    @Test
    void mapToCarRentDtoTest() {
        //Given
        CarRentMapper carRentMapper = new CarRentMapper();
        CarRent carRent = CarRent.builder()
                .carRentId(2L)
                .rentalDate(LocalDate.of(2022, 3, 2))
                .rentalHour(LocalTime.of(10, 10))
                .returnDate(LocalDate.of(2022, 3, 12))
                .returnHour(LocalTime.of(20, 20))
                .rentalDayLength(10)
                .currency(Currency.PLN)
                .dailyRate(BigDecimal.valueOf(100))
                .additionalCosts(BigDecimal.ZERO)
                .deposit(BigDecimal.ZERO)
                .totalCost(BigDecimal.ZERO)
                .dailyMileageLimit(DailyMileageLimit.NIE)
                .travelAbroad(TravelAbroad.NIE)
                .registrationCertificate(RegistrationCertificate.NIE)
                .abolitionDeductibleInDamage(AbolitionDeductibleInDamage.NIE)
                .abolitionFee(BigDecimal.ZERO)
                .isActive(false)
                .cleanCarBodyRelease(CleanCarBody.NIE)
                .cleanCarInteriorRelease(CleanCarInterior.NIE)
                .amountOfFuelRelease("PEŁNY")
                .carMileageRelease(50000L)
                .remarksRelease(null)
                .cleanCarBodyReturn(CleanCarBody.NIE)
                .cleanCarInteriorReturn(CleanCarInterior.NIE)
                .amountOfFuelReturn("PEŁNY")
                .carMileageReturn(55000L)
                .newCarDamage(null)
                .remarksReturn(null)
                .depositRefund(BigDecimal.ZERO)
                .build();

        //When
        CarRentDto carRentDto = carRentMapper.mapToCarRentDto(carRent);
        //Then
        assertNotNull(carRentDto.getCarRentId());
        assertEquals(2L, carRentDto.getCarRentId());
        assertEquals(LocalTime.of(20,20), carRentDto.getReturnHour());
    }

    @Test
    void mapToCarRentDtoListTest() {
        //Given
        CarRentMapper carRentMapper = new CarRentMapper();
        List<CarRent> carRentList = new ArrayList<>();

        CarRent carRent1 = CarRent.builder()
                .carRentId(1L)
                .rentalDate(LocalDate.of(2022, 3, 2))
                .rentalHour(LocalTime.of(10, 10))
                .returnDate(LocalDate.of(2022, 3, 12))
                .returnHour(LocalTime.of(20, 20))
                .rentalDayLength(10)
                .currency(Currency.PLN)
                .dailyRate(BigDecimal.valueOf(100))
                .additionalCosts(BigDecimal.ZERO)
                .deposit(BigDecimal.ZERO)
                .totalCost(BigDecimal.ZERO)
                .dailyMileageLimit(DailyMileageLimit.NIE)
                .travelAbroad(TravelAbroad.NIE)
                .registrationCertificate(RegistrationCertificate.NIE)
                .abolitionDeductibleInDamage(AbolitionDeductibleInDamage.NIE)
                .abolitionFee(BigDecimal.ZERO)
                .isActive(false)
                .cleanCarBodyRelease(CleanCarBody.NIE)
                .cleanCarInteriorRelease(CleanCarInterior.NIE)
                .amountOfFuelRelease("PEŁNY")
                .carMileageRelease(50000L)
                .remarksRelease(null)
                .cleanCarBodyReturn(CleanCarBody.NIE)
                .cleanCarInteriorReturn(CleanCarInterior.NIE)
                .amountOfFuelReturn("PEŁNY")
                .carMileageReturn(55000L)
                .newCarDamage(null)
                .remarksReturn(null)
                .depositRefund(BigDecimal.ZERO)
                .build();

        CarRent carRent2 = CarRent.builder()
                .carRentId(2L)
                .rentalDate(LocalDate.of(2022, 3, 2))
                .rentalHour(LocalTime.of(10, 10))
                .returnDate(LocalDate.of(2022, 3, 12))
                .returnHour(LocalTime.of(20, 20))
                .rentalDayLength(10)
                .currency(Currency.PLN)
                .dailyRate(BigDecimal.valueOf(100))
                .additionalCosts(BigDecimal.ZERO)
                .deposit(BigDecimal.ZERO)
                .totalCost(BigDecimal.ZERO)
                .dailyMileageLimit(DailyMileageLimit.NIE)
                .travelAbroad(TravelAbroad.NIE)
                .registrationCertificate(RegistrationCertificate.NIE)
                .abolitionDeductibleInDamage(AbolitionDeductibleInDamage.NIE)
                .abolitionFee(BigDecimal.ZERO)
                .isActive(false)
                .cleanCarBodyRelease(CleanCarBody.NIE)
                .cleanCarInteriorRelease(CleanCarInterior.NIE)
                .amountOfFuelRelease("PEŁNY")
                .carMileageRelease(50000L)
                .remarksRelease(null)
                .cleanCarBodyReturn(CleanCarBody.NIE)
                .cleanCarInteriorReturn(CleanCarInterior.NIE)
                .amountOfFuelReturn("PEŁNY")
                .carMileageReturn(55000L)
                .newCarDamage(null)
                .remarksReturn(null)
                .depositRefund(BigDecimal.ZERO)
                .build();

        carRentList.add(carRent1);
        carRentList.add(carRent2);
        //When
        List<CarRentDto> carRentDtoList = carRentMapper.mapToCarRentDtoList(carRentList);
        //Then
        assertNotNull(carRentDtoList.get(1).getCarRentId());
        assertEquals(2, carRentDtoList.size());
        assertEquals(Currency.PLN, carRentDtoList.get(0).getCurrency());
        assertEquals(LocalDate.of(2022, 3, 2), carRentDtoList.get(1).getRentalDate());
    }
}
