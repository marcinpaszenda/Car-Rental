package com.carrental.controller;

import com.carrental.domain.CarReleaseReport;
import com.carrental.domain.dto.CarReleaseReportDto;
import com.carrental.exceptions.CarReleaseReportNotFoundException;
import com.carrental.mapper.CarReleaseReportMapper;
import com.carrental.service.CarReleaseReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/carReleaseReport")
public class CarReleaseReportController {

    private final CarReleaseReportMapper carReleaseReportMapper;
    private final CarReleaseReportService carReleaseReportService;

    @GetMapping(value = "{carReleaseReportId}")
    public ResponseEntity<CarReleaseReportDto> getCarReleaseReport
            (@PathVariable Long carReleaseReportId) throws CarReleaseReportNotFoundException {
        return ResponseEntity.ok(carReleaseReportMapper.mapToCarReleaseReportDto
                (carReleaseReportService.findCarReleaseReportById(carReleaseReportId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarReleaseReport> addCarReleaseReport(@RequestBody CarReleaseReportDto carReleaseReportDto) {
        CarReleaseReport carReleaseReport = carReleaseReportMapper.mapToCarReleaseReport(carReleaseReportDto);
        carReleaseReportService.saveCarReleaseReport(carReleaseReport);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carReleaseReport);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarReleaseReport> updateCarReleaseReport(@RequestBody CarReleaseReportDto carReleaseReportDto)
            throws CarReleaseReportNotFoundException {
        CarReleaseReport carReleaseReport = carReleaseReportMapper.mapToCarReleaseReport(carReleaseReportDto);
        CarReleaseReport updatedCarReleaseReport = carReleaseReportService.updateCarReleaseReport(carReleaseReport);
        carReleaseReportMapper.mapToCarReleaseReportDto(updatedCarReleaseReport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{carReleaseReportId}")
    public ResponseEntity<Void> deleteCarReleaseReport(@PathVariable Long carReleaseReportId)
            throws CarReleaseReportNotFoundException {
        carReleaseReportService.deleteCarReleaseReport(carReleaseReportId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
