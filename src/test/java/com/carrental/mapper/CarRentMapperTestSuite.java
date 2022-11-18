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
        CarRentDto carRentDto = new CarRentDto(1L, LocalDate.of(2022, 3, 2),
                LocalTime.of(10, 10), LocalDate.of(2022, 3, 12),
                LocalTime.of(20, 20), 10L,
                Currency.PLN, BigDecimal.valueOf(100), null, null,
                null, DailyMileageLimit.TAK, TravelAbroad.NIE, RegistrationCertificate.NIE,
                AbolitionDeductibleInDamage.NIE, null, null, null,
                null, null, null);
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
        CarRent carRent = new CarRent(2L, LocalDate.of(2022, 6, 6),
                LocalTime.of(12, 12), LocalDate.of(2022, 6, 12),
                LocalTime.of(10, 2), 6L, Currency.PLN, BigDecimal.valueOf(150),
                null, null, null, DailyMileageLimit.TAK, TravelAbroad.NIE,
                RegistrationCertificate.NIE, AbolitionDeductibleInDamage.NIE, null, null, null,
                null, null, null);
        //When
        CarRentDto carRentDto = carRentMapper.mapToCarRentDto(carRent);
        //Then
        assertNotNull(carRentDto.getCarRentId());
        assertEquals(2L, carRentDto.getCarRentId());
        assertEquals(LocalTime.of(10,2), carRentDto.getReturnHour());
    }

    @Test
    void mapToCarRentDtoListTest() {
        //Given
        CarRentMapper carRentMapper = new CarRentMapper();
        List<CarRent> carRentList = new ArrayList<>();
        CarRent carRent1 = new CarRent(1L, LocalDate.of(2022, 3, 2),
                LocalTime.of(10, 10), LocalDate.of(2022, 3, 12),
                LocalTime.of(20, 20), 10L,
                Currency.PLN, BigDecimal.valueOf(100), null, null,
                null, DailyMileageLimit.TAK, TravelAbroad.NIE, RegistrationCertificate.NIE,
                AbolitionDeductibleInDamage.NIE, null, null, null,
                null, null, null);
        CarRent carRent2 = new CarRent(2L, LocalDate.of(2022, 6, 6),
                LocalTime.of(12, 12), LocalDate.of(2022, 6, 12),
                LocalTime.of(10, 2), 6L, Currency.PLN, BigDecimal.valueOf(150),
                null, null, null, DailyMileageLimit.TAK, TravelAbroad.NIE,
                RegistrationCertificate.NIE, AbolitionDeductibleInDamage.NIE, null, null, null,
                null, null, null);
        carRentList.add(carRent1);
        carRentList.add(carRent2);
        //When
        List<CarRentDto> carRentDtoList = carRentMapper.mapToCarRentDtoList(carRentList);
        //Then
        assertNotNull(carRentDtoList.get(1).getCarRentId());
        assertEquals(2, carRentDtoList.size());
        assertEquals(Currency.PLN, carRentDtoList.get(0).getCurrency());
        assertEquals(LocalDate.of(2022, 6, 6), carRentDtoList.get(1).getRentalDate());
    }
}
