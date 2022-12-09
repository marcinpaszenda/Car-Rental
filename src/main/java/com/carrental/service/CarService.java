package com.carrental.service;

import com.carrental.domain.Car;
import com.carrental.domain.enums.CarStatus;
import com.carrental.exceptions.CarNotFoundException;
import com.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car findCarById(final Long carId) throws CarNotFoundException {
        return carRepository.findById(carId).orElseThrow(CarNotFoundException::new);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(final Car car) throws CarNotFoundException {
        if (carRepository.existsById(car.getCarId())) {
            carRepository.save(car);
            return car;
        } else {
            throw new CarNotFoundException();
        }
    }

    public void deleteCar(Long carId) throws CarNotFoundException {
        if (carRepository.existsById(carId)) {
            carRepository.deleteById(carId);
        } else {
            throw new CarNotFoundException();
        }
    }

    public void carStatus() throws CarNotFoundException {

        for (Car car : carRepository.findAll()) {

            long status = car.getCarRentList().stream()
                    .filter(carRent -> carRent.getReturnDate() == null || (carRent.getReturnDate().isAfter(LocalDate.now().minusDays(1))))
                    .count();
            if (status > 0) {
                car.setCarStatus(CarStatus.WYPOŻYCZONY);
                updateCar(car);
            } else {
                car.setCarStatus(CarStatus.DOSTĘPNY);
                updateCar(car);
            }

        }
    }

}
