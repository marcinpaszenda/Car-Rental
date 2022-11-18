package com.carrental.mapper;

import com.carrental.domain.CarReleaseReport;
import com.carrental.domain.dto.CarReleaseReportDto;
import org.springframework.stereotype.Service;

@Service
public class CarReleaseReportMapper {

    public CarReleaseReport mapToCarReleaseReport(final CarReleaseReportDto carReleaseReportDto) {
        return new CarReleaseReport(
                carReleaseReportDto.getCarReleaseReportId(),
                carReleaseReportDto.getCleanCarBody(),
                carReleaseReportDto.getCleanCarInterior(),
                carReleaseReportDto.getAmountOfFuel(),
                carReleaseReportDto.getCarMileage(),
                carReleaseReportDto.getRemarks()
        );
    }

    public CarReleaseReportDto mapToCarReleaseReportDto(final CarReleaseReport carReleaseReport) {
        return new CarReleaseReportDto(
                carReleaseReport.getCarReleaseReportId(),
                carReleaseReport.getCleanCarBody(),
                carReleaseReport.getCleanCarInterior(),
                carReleaseReport.getAmountOfFuel(),
                carReleaseReport.getCarMileage(),
                carReleaseReport.getRemarks()
        );
    }
}
