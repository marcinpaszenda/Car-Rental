package com.carrental.service;

import com.carrental.domain.CarReleaseReport;
import com.carrental.exceptions.CarReleaseReportNotFoundException;
import com.carrental.repository.CarReleaseReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarReleaseReportService {

    private final CarReleaseReportRepository carReleaseReportRepository;

    public CarReleaseReport findCarReleaseReportById(final Long carReleaseReportId) throws CarReleaseReportNotFoundException {
        return carReleaseReportRepository.findById(carReleaseReportId).orElseThrow(CarReleaseReportNotFoundException::new);
    }

    public CarReleaseReport saveCarReleaseReport(CarReleaseReport carReleaseReport) {
        return carReleaseReportRepository.save(carReleaseReport);
    }

    public CarReleaseReport updateCarReleaseReport(final CarReleaseReport carReleaseReport) throws CarReleaseReportNotFoundException {
        if (carReleaseReportRepository.existsById(carReleaseReport.getCarReleaseReportId())) {
            carReleaseReportRepository.save(carReleaseReport);
            return carReleaseReport;
        } else {
            throw new CarReleaseReportNotFoundException();
        }
    }

    public void deleteCarReleaseReport(Long carReleaseReportId) throws CarReleaseReportNotFoundException {
        if (carReleaseReportRepository.existsById(carReleaseReportId)) {
            carReleaseReportRepository.deleteById(carReleaseReportId);
        } else {
            throw new CarReleaseReportNotFoundException();
        }
    }
}
