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
        CarRent carRent1 = new CarRent(1L, LocalDate.of(2022, 3, 2),
                LocalTime.of(10, 10), LocalDate.of(2022, 3, 12),
                LocalTime.of(20, 20), 10L,
                Currency.PLN, BigDecimal.valueOf(100), null, null,
                null, DailyMileageLimit.TAK, TravelAbroad.NIE, RegistrationCertificate.NIE,
                AbolitionDeductibleInDamage.NIE, null, false, null,
                null, null, null, null);
        CarRent carRent2 = new CarRent(2L, LocalDate.of(2022, 6, 6),
                LocalTime.of(12, 12), LocalDate.of(2022, 6, 12),
                LocalTime.of(10, 2), 6L, Currency.PLN, BigDecimal.valueOf(150),
                null, null, null, DailyMileageLimit.TAK, TravelAbroad.NIE,
                RegistrationCertificate.NIE, AbolitionDeductibleInDamage.NIE, null, false, null,
                null, null, null, null);
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
        //Given
        CarRent carRent1 = new CarRent(1L, LocalDate.of(2022, 3, 2),
                LocalTime.of(10, 10), LocalDate.of(2022, 3, 12),
                LocalTime.of(20, 20), 10L,
                Currency.PLN, BigDecimal.valueOf(100), null, null,
                null, DailyMileageLimit.TAK, TravelAbroad.NIE, RegistrationCertificate.NIE,
                AbolitionDeductibleInDamage.NIE, null, false, null,
                null, null, null, null);
        when(carRentRepository.findById(1L)).thenReturn(Optional.of(carRent1));
        //When
        CarRent result = carRentService.findCarRentById(1L);
        //Then
        assertEquals(carRent1, result);
    }

    @Test
    void saveCarRentTest() throws CarRentNotFoundException {
        //Given
        CarRent carRent1 = new CarRent(1L, LocalDate.of(2022, 3, 2),
                LocalTime.of(10, 10), LocalDate.of(2022, 3, 12),
                LocalTime.of(20, 20), 10L,
                Currency.PLN, BigDecimal.valueOf(100), null, null,
                null, DailyMileageLimit.TAK, TravelAbroad.NIE, RegistrationCertificate.NIE,
                AbolitionDeductibleInDamage.NIE, null, false, null,
                null, null, null, null);
        when(carRentRepository.findById(1L)).thenReturn(Optional.of(carRent1));
        //When
        CarRent updateCarRent = carRentService.findCarRentById(1L);
        updateCarRent.setTotalCost(BigDecimal.valueOf(800));
        carRentService.saveCarRent(updateCarRent);
        //Then
        assertEquals(BigDecimal.valueOf(800), updateCarRent.getTotalCost());
    }
}
