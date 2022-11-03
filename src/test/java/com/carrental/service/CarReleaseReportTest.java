package com.carrental.service;

import com.carrental.domain.CarReleaseReport;
import com.carrental.exceptions.CarReleaseReportNotFoundException;
import com.carrental.repository.CarReleaseReportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarReleaseReportTest {

    @InjectMocks
    private CarReleaseReportService carReleaseReportService;

    @Mock
    private CarReleaseReportRepository carReleaseReportRepository;

    @Test
    void getCarReleaseReportTest() throws CarReleaseReportNotFoundException {
        //Given
        CarReleaseReport carReleaseReport1 = new CarReleaseReport(1L, true, true, 100, 22000L, "no remarks");
        when(carReleaseReportRepository.findById(1L)).thenReturn(Optional.of(carReleaseReport1));
        //When
        CarReleaseReport result = carReleaseReportService.findCarReleaseReportById(1L);
        //Then
        assertEquals(carReleaseReport1, result);
    }

    @Test
    void saveCarReleaseReportTest() throws CarReleaseReportNotFoundException {
        //Given
        CarReleaseReport carReleaseReport1 = new CarReleaseReport(1L, true, true, 100, 22000L, "no remarks");
        when(carReleaseReportRepository.findById(1L)).thenReturn(Optional.of(carReleaseReport1));
        //When
        CarReleaseReport updateCarReleaseReport = carReleaseReportService.findCarReleaseReportById(1L);
        updateCarReleaseReport.setCleanCarBody(false);
        carReleaseReportService.saveCarReleaseReport(updateCarReleaseReport);
        //Then
        assertFalse(updateCarReleaseReport.isCleanCarBody());
    }
}
