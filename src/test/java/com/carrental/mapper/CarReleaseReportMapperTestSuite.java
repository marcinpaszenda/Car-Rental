package com.carrental.mapper;

import com.carrental.domain.CarReleaseReport;
import com.carrental.domain.dto.CarReleaseReportDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarReleaseReportMapperTestSuite {

    @Test
    void mapToCarReleaseReportTest() {
        //Given
        CarReleaseReportMapper carReleaseReportMapper = new CarReleaseReportMapper();
        CarReleaseReportDto carReleaseReportDto = new CarReleaseReportDto(1L, true, true, 100, 55000L, "no remarks");
        //When
        CarReleaseReport carReleaseReport = carReleaseReportMapper.mapToCarReleaseReport(carReleaseReportDto);
        //Then
        assertNotNull(carReleaseReport.getCarReleaseReportId());
        assertEquals(55000, carReleaseReport.getCarMileage());
    }

    @Test
    void mapToCarReleaseReportDtoTest() {
        //Given
        CarReleaseReportMapper carReleaseReportMapper = new CarReleaseReportMapper();
        CarReleaseReport carReleaseReport = new CarReleaseReport(2L, false, true, 75, 60000L, "no remarks");
        //When
        CarReleaseReportDto carReleaseReportDto = carReleaseReportMapper.mapToCarReleaseReportDto(carReleaseReport);
        //Then
        assertNotNull(carReleaseReportDto.getCarReleaseReportId());
        assertFalse(carReleaseReportDto.isCleanCarBody());
        assertEquals(75, carReleaseReportDto.getAmountOfFuel());
    }
}
