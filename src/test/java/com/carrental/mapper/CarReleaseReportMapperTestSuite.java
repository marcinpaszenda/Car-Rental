package com.carrental.mapper;

import com.carrental.domain.CarReleaseReport;
import com.carrental.domain.dto.CarReleaseReportDto;
import com.carrental.domain.enums.CleanCarBody;
import com.carrental.domain.enums.CleanCarInterior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarReleaseReportMapperTestSuite {

    @Test
    void mapToCarReleaseReportTest() {
        //Given
        CarReleaseReportMapper carReleaseReportMapper = new CarReleaseReportMapper();
        CarReleaseReportDto carReleaseReportDto = new CarReleaseReportDto(1L, CleanCarBody.TAK, CleanCarInterior.TAK, 100, 55000L, "no remarks");
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
        CarReleaseReport carReleaseReport = new CarReleaseReport(2L, CleanCarBody.NIE, CleanCarInterior.TAK, 75, 60000L, "no remarks");
        //When
        CarReleaseReportDto carReleaseReportDto = carReleaseReportMapper.mapToCarReleaseReportDto(carReleaseReport);
        //Then
        assertNotNull(carReleaseReportDto.getCarReleaseReportId());
        assertEquals(CleanCarBody.NIE, carReleaseReportDto.getCleanCarBody());
        assertEquals(75, carReleaseReportDto.getAmountOfFuel());
    }
}
