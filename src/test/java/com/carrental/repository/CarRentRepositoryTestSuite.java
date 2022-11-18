package com.carrental.repository;

import com.carrental.domain.CarRent;
import com.carrental.domain.enums.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CarRentRepositoryTestSuite {

    @Autowired
    private CarRentRepository carRentRepository;
    private CarRent carRent;

    @BeforeEach
    public void beforeTests() {
        carRent = CarRent.builder()
                .rentalDate(LocalDate.of(2022, 9, 12))
                .rentalHour(LocalTime.of(12, 12))
                .returnDate(LocalDate.of(2022, 9, 22))
                .returnHour(LocalTime.of(15, 55))
                .rentalDayLength(10L)
                .currency(Currency.PLN)
                .dailyRate(BigDecimal.valueOf(100.00))
                .additionalCosts(BigDecimal.ZERO)
                .deposit(BigDecimal.valueOf(1000))
                .totalCost(BigDecimal.valueOf(1000))
                .dailyMileageLimit(DailyMileageLimit.NIE)
                .travelAbroad(TravelAbroad.NIE)
                .registrationCertificate(RegistrationCertificate.NIE)
                .abolitionDeductibleInDamage(AbolitionDeductibleInDamage.NIE)
                .abolitionFee(BigDecimal.ZERO)
                .build();
    }

    @Test
    public void saveCarRentTest() {
        //Given
        //When
        carRentRepository.save(carRent);
        //Then
        assertTrue(carRentRepository.existsById(carRent.getCarRentId()));
        assertEquals(LocalDate.of(2022, 9, 12), carRent.getRentalDate());
        //CleanUp
        carRentRepository.deleteById(carRent.getCarRentId());
    }

    @Test
    public void findCarRentByIdTest() {
        //Given
        carRentRepository.save(carRent);
        BigDecimal dailyRate = BigDecimal.valueOf(100);
        //When
        CarRent result = carRentRepository.findById(carRent.getCarRentId()).get();
        //Then
        assertEquals(BigDecimal.ZERO, result.getAbolitionFee());
        assertEquals(dailyRate, result.getDailyRate());
        //CleanUp
        carRentRepository.deleteById(carRent.getCarRentId());
    }

    @Test
    public void deleteDriverByIdTest() {
        //Given
        carRentRepository.save(carRent);
        //When
        carRentRepository.deleteById(carRent.getCarRentId());
        //Then
        assertEquals(Optional.empty(), carRentRepository.findById(carRent.getCarRentId()));
    }
}
