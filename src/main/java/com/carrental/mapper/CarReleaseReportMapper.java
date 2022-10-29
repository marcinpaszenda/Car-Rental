package com.carrental.mapper;

import com.carrental.domain.CarReleaseReport;
import com.carrental.domain.dto.CarReleaseReportDto;
import org.springframework.stereotype.Service;

@Service
public class CarReleaseReportMapper {

    public CarReleaseReport mapToCarReleaseReport(final CarReleaseReportDto carReleaseReportDto) {
        return new CarReleaseReport(
                carReleaseReportDto.getCarReleaseReportId(),
                carReleaseReportDto.isCleanCarBody(),
                carReleaseReportDto.isCleanCarInterior(),
                carReleaseReportDto.getAmountOfFuel(),
                carReleaseReportDto.getCarMileage(),
                carReleaseReportDto.getRemarks()
        );
    }

    public CarReleaseReportDto mapToCarReleaseReportDto(final CarReleaseReport carReleaseReport) {
        return new CarReleaseReportDto(
                carReleaseReport.getCarReleaseReportId(),
                carReleaseReport.isCleanCarBody(),
                carReleaseReport.isCleanCarInterior(),
                carReleaseReport.getAmountOfFuel(),
                carReleaseReport.getCarMileage(),
                carReleaseReport.getRemarks()
        );
    }
}
