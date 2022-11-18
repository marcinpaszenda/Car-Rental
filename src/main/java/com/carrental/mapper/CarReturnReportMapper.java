package com.carrental.mapper;

import com.carrental.domain.CarReturnReport;
import com.carrental.domain.dto.CarReturnReportDto;
import org.springframework.stereotype.Service;

@Service
public class CarReturnReportMapper {

    public CarReturnReport mapToCarReturnReport(CarReturnReportDto carReturnReportDto) {
        return new CarReturnReport(
                carReturnReportDto.getCarReturnReportId(),
                carReturnReportDto.getCleanCarBody(),
                carReturnReportDto.getCleanCarInterior(),
                carReturnReportDto.getAmountOfFuel(),
                carReturnReportDto.getCarMileage(),
                carReturnReportDto.getNewCarDamage(),
                carReturnReportDto.getRemarks(),
                carReturnReportDto.getDepositRefund()
        );
    }

    public CarReturnReportDto mapToCarReturnReportDto(CarReturnReport carReturnReport) {
        return new CarReturnReportDto(
                carReturnReport.getCarReturnReportId(),
                carReturnReport.getCleanCarBody(),
                carReturnReport.getCleanCarInterior(),
                carReturnReport.getAmountOfFuel(),
                carReturnReport.getCarMileage(),
                carReturnReport.getNewCarDamage(),
                carReturnReport.getRemarks(),
                carReturnReport.getDepositRefund()
        );
    }
}
