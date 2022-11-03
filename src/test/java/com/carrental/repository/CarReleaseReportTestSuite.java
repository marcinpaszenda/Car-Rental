package com.carrental.repository;

import com.carrental.domain.CarReleaseReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CarReleaseReportTestSuite {

    @Autowired
    private CarReleaseReportRepository carReleaseReportRepository;
    private CarReleaseReport carReleaseReport;

    @BeforeEach
    public void beforeTests() {
        carReleaseReport = CarReleaseReport.builder()
                .cleanCarBody(true)
                .cleanCarInterior(true)
                .amountOfFuel(100)
                .carMileage(33300L)
                .remarks("ok")
                .build();
    }

    @Test
    public void saveCarReleaseReportTest() {
        //Given
        //When
        carReleaseReportRepository.save(carReleaseReport);
        //Then
        assertTrue(carReleaseReportRepository.existsById(carReleaseReport.getCarReleaseReportId()));
        assertEquals("ok", carReleaseReport.getRemarks());
        //CleanUp
        carReleaseReportRepository.deleteById(carReleaseReport.getCarReleaseReportId());
    }

    @Test
    public void findCarReleaseReportTest() {
        //Given
        carReleaseReportRepository.save(carReleaseReport);
        //When
        CarReleaseReport result = carReleaseReportRepository.findById(carReleaseReport.getCarReleaseReportId()).get();
        //Then
        assertEquals(33300L, result.getCarMileage());
        assertEquals(100, result.getAmountOfFuel());
        //CleanUp
        carReleaseReportRepository.deleteById(carReleaseReport.getCarReleaseReportId());
    }

    @Test
    public void deleteCarReleaseReportTest() {
        //Given
        carReleaseReportRepository.save(carReleaseReport);
        //When
        carReleaseReportRepository.deleteById(carReleaseReport.getCarReleaseReportId());
        //Then
        assertEquals(Optional.empty(), carReleaseReportRepository.findById(carReleaseReport.getCarReleaseReportId()));
    }
}
