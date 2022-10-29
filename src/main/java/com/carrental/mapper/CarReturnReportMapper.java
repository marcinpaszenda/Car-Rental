package com.carrental.mapper;

import com.carrental.domain.CarReturnReport;
import com.carrental.domain.dto.CarReturnReportDto;
import org.springframework.stereotype.Service;

@Service
public class CarReturnReportMapper {

    public CarReturnReport mapToCarReturnReport(CarReturnReportDto carReturnReportDto) {
        return new CarReturnReport(
                carReturnReportDto.getCarReturnReportId(),
                carReturnReportDto.isCleanCarBody(),
                carReturnReportDto.isCleanCarInterior(),
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
                carReturnReport.isCleanCarBody(),
                carReturnReport.isCleanCarInterior(),
                carReturnReport.getAmountOfFuel(),
                carReturnReport.getCarMileage(),
                carReturnReport.getNewCarDamage(),
                carReturnReport.getRemarks(),
                carReturnReport.getDepositRefund()
        );
    }
}
