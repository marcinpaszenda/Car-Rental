package com.carrental.repository;

import com.carrental.domain.CarReturnReport;
import com.carrental.domain.enums.CleanCarBody;
import com.carrental.domain.enums.CleanCarInterior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CarReturnReportTestSuite {

    @Autowired
    private CarReturnReportRepository carReturnReportRepository;
    private CarReturnReport carReturnReport;

    @BeforeEach
    public void beforeTests() {
        carReturnReport = CarReturnReport.builder()
                .cleanCarBody(CleanCarBody.TAK)
                .cleanCarInterior(CleanCarInterior.TAK)
                .amountOfFuel(100)
                .carMileage(40000L)
                .newCarDamage("no damage")
                .remarks("ok")
                .depositRefund(BigDecimal.valueOf(200))
                .build();
    }

    @Test
    public void saveCarReturnReportTest() {
        //Given
        //When
        carReturnReportRepository.save(carReturnReport);
        //Then
        assertTrue(carReturnReportRepository.existsById(carReturnReport.getCarReturnReportId()));
        assertEquals("ok", carReturnReport.getRemarks());
        //CleanUp
        carReturnReportRepository.deleteById(carReturnReport.getCarReturnReportId());
    }

    @Test
    public void findCarReturnReportTest() {
        //Given
        carReturnReportRepository.save(carReturnReport);
        String carDamage = "no damage";
        //When
        CarReturnReport result = carReturnReportRepository.findById(carReturnReport.getCarReturnReportId()).get();
        //Then
        assertEquals(BigDecimal.valueOf(200), result.getDepositRefund());
        assertEquals(carDamage, result.getNewCarDamage());
        //CleanUp
        carReturnReportRepository.deleteById(carReturnReport.getCarReturnReportId());
    }

    @Test
    public void deleteCarReturnReportByIdTest() {
        //Given
        carReturnReportRepository.save(carReturnReport);
        //When
        carReturnReportRepository.deleteById(carReturnReport.getCarReturnReportId());
        //Then
        assertEquals(Optional.empty(), carReturnReportRepository.findById(carReturnReport.getCarReturnReportId()));
    }
}
