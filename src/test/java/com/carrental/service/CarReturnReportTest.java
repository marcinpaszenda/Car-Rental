package com.carrental.service;

import com.carrental.domain.CarReturnReport;
import com.carrental.exceptions.CarReturnReportNotFoundException;
import com.carrental.repository.CarReturnReportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarReturnReportTest {

    @InjectMocks
    private CarReturnReportService carReturnReportService;

    @Mock
    private CarReturnReportRepository carReturnReportRepository;

    @Test
    void getCarReturnReportTest() throws CarReturnReportNotFoundException {
        //Given
        CarReturnReport carReturnReport = new CarReturnReport(1L, true, true, 90, 12000L, "no damage", "no remarks", null);
        when(carReturnReportRepository.findById(1L)).thenReturn(Optional.of(carReturnReport));
        //When
        CarReturnReport result = carReturnReportService.findCarReturnReportById(1L);
        //Then
        assertEquals(carReturnReport, result);
    }

    @Test
    void saveCarReturnReportTest() throws CarReturnReportNotFoundException {
        //Given
        CarReturnReport carReturnReport = new CarReturnReport(1L, true, true, 90, 12000L, "no damage", "no remarks", null);
        when(carReturnReportRepository.findById(1L)).thenReturn(Optional.of(carReturnReport));
        //When
        CarReturnReport updateCarReturnReport = carReturnReportService.findCarReturnReportById(1L);
        updateCarReturnReport.setNewCarDamage("Scratch on door");
        carReturnReportService.saveCarReturnReport(updateCarReturnReport);
        //Then
        assertEquals("Scratch on door", updateCarReturnReport.getNewCarDamage());
    }
}
