package com.carrental.mapper;

import com.carrental.domain.CarReturnReport;
import com.carrental.domain.dto.CarReturnReportDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarReturnReportMapperTestSuite {

    @Test
    void mapToCarReturnReportTest() {
        //Given
        CarReturnReportMapper carReturnReportMapper = new CarReturnReportMapper();
        CarReturnReportDto carReturnReportDto = new CarReturnReportDto(1L, true, false, 10, 22331L, "no damage", null, BigDecimal.valueOf(500));
        //When
        CarReturnReport carReturnReport = carReturnReportMapper.mapToCarReturnReport(carReturnReportDto);
        //Then
        assertNotNull(carReturnReport.getCarReturnReportId());
        assertEquals(10, carReturnReport.getAmountOfFuel());
    }

    @Test
    void mapToCarReturnReportDtoTest() {
        //Given
        CarReturnReportMapper carReturnReportMapper = new CarReturnReportMapper();
        CarReturnReport carReturnReport = new CarReturnReport(2L, false, false, 100, 44444L, null, null, BigDecimal.valueOf(1000));
        //When
        CarReturnReportDto carReturnReportDto = carReturnReportMapper.mapToCarReturnReportDto(carReturnReport);
        //Then
        assertNotNull(carReturnReportDto.getCarReturnReportId());
        assertEquals(BigDecimal.valueOf(1000), carReturnReportDto.getDepositRefund());
    }
}
