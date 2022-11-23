package com.carrental.service;

import com.carrental.domain.CarRent;
import com.carrental.domain.enums.*;
import com.carrental.exceptions.CarRentNotFoundException;
import com.carrental.repository.CarRentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarRentServiceTest {

    @InjectMocks
    private CarRentService carRentService;

    @Mock
    private CarRentRepository carRentRepository;

    @Test
    void getAllCarRentsTest() {
        //Given
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
        when(carRentRepository.findAll()).thenReturn(carRentList);
        //When
        List<CarRent> resultList = carRentService.getAllCarRents();
        //Then
        assertEquals(2, resultList.size());
    }

    @Test
    void getCarRentTest() throws CarRentNotFoundException {

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

        when(carRentRepository.findById(1L)).thenReturn(Optional.of(carRent1));
        //When
        CarRent result = carRentService.findCarRentById(1L);
        //Then
        assertEquals(carRent1, result);
    }

    @Test
    void saveCarRentTest() throws CarRentNotFoundException {

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

        when(carRentRepository.findById(1L)).thenReturn(Optional.of(carRent1));
        //When
        CarRent updateCarRent = carRentService.findCarRentById(1L);
        updateCarRent.setTotalCost(BigDecimal.valueOf(800));
        carRentService.saveCarRent(updateCarRent);
        //Then
        assertEquals(BigDecimal.valueOf(800), updateCarRent.getTotalCost());
    }
}
