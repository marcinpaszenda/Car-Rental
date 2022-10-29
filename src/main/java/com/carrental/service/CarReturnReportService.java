package com.carrental.service;

import com.carrental.domain.CarReturnReport;
import com.carrental.exceptions.CarReturnReportNotFoundException;
import com.carrental.repository.CarReturnReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarReturnReportService {

    private final CarReturnReportRepository carReturnReportRepository;

    public CarReturnReport findCarReturnReportById(final Long carReturnReportId) throws CarReturnReportNotFoundException {
        return carReturnReportRepository.findById(carReturnReportId).orElseThrow(CarReturnReportNotFoundException::new);
    }

    public CarReturnReport saveCarReturnReport(CarReturnReport carReturnReport) {
        return carReturnReportRepository.save(carReturnReport);
    }

    public CarReturnReport updateCarReturnReport(final CarReturnReport carReturnReport) throws CarReturnReportNotFoundException {
        if (carReturnReportRepository.existsById(carReturnReport.getCarReturnReportId())) {
            carReturnReportRepository.save(carReturnReport);
            return carReturnReport;
        } else {
            throw new CarReturnReportNotFoundException();
        }
    }

    public void deleteCarReturnReport(Long carReturnReportId) throws CarReturnReportNotFoundException {
        if (carReturnReportRepository.existsById(carReturnReportId)) {
            carReturnReportRepository.deleteById(carReturnReportId);
        } else {
            throw new CarReturnReportNotFoundException();
        }
    }
}
