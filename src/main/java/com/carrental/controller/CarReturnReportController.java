package com.carrental.controller;

import com.carrental.domain.CarReturnReport;
import com.carrental.domain.dto.CarReturnReportDto;
import com.carrental.exceptions.CarReturnReportNotFoundException;
import com.carrental.mapper.CarReturnReportMapper;
import com.carrental.service.CarReturnReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/carReturnReport")
public class CarReturnReportController {

    private final CarReturnReportMapper carReturnReportMapper;
    private final CarReturnReportService carReturnReportService;

    @GetMapping(value = "{carReturnReportId}")
    public ResponseEntity<CarReturnReportDto> getCarReturnReport
            (@PathVariable Long carReturnReportId) throws CarReturnReportNotFoundException {
        return ResponseEntity.ok(carReturnReportMapper.mapToCarReturnReportDto
                (carReturnReportService.findCarReturnReportById(carReturnReportId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarReturnReport> addCarReturnReport(@RequestBody CarReturnReportDto carReturnReportDto) {
        CarReturnReport carReturnReport = carReturnReportMapper.mapToCarReturnReport(carReturnReportDto);
        carReturnReportService.saveCarReturnReport(carReturnReport);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carReturnReport);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarReturnReport> updateCarReturnReport(@RequestBody CarReturnReportDto carReturnReportDto)
            throws CarReturnReportNotFoundException {
        CarReturnReport carReturnReport = carReturnReportMapper.mapToCarReturnReport(carReturnReportDto);
        CarReturnReport updatedCarReturnReport = carReturnReportService.updateCarReturnReport(carReturnReport);
        carReturnReportMapper.mapToCarReturnReportDto(updatedCarReturnReport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{carReturnReportId}")
    public ResponseEntity<Void> deleteCarReturnReport(@PathVariable Long carReturnReportId)
            throws CarReturnReportNotFoundException {
        carReturnReportService.deleteCarReturnReport(carReturnReportId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

