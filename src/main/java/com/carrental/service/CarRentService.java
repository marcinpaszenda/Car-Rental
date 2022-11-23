package com.carrental.service;

import com.carrental.domain.Car;
import com.carrental.domain.CarRent;
import com.carrental.exceptions.CarNotFoundException;
import com.carrental.exceptions.CarRentNotFoundException;
import com.carrental.repository.CarRentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarRentService {

    private final CarRentRepository carRentRepository;
    private final CarService carService;

    public List<CarRent> getAllCarRents() {
        return carRentRepository.findAll();
    }

    public CarRent findCarRentById(final Long carRentId) throws CarRentNotFoundException {
        return carRentRepository.findById(carRentId).orElseThrow(CarRentNotFoundException::new);
    }

    public CarRent saveCarRent(final CarRent carRent) {
        return carRentRepository.save(carRent);
    }

    public CarRent updateCarRent(final CarRent carRent) throws CarRentNotFoundException {
        if (carRentRepository.existsById(carRent.getCarRentId())) {
            carRentRepository.save(carRent);
            return carRent;
        } else {
            throw new CarRentNotFoundException();
        }
    }

    public void deleteCarRent(Long carRentId) throws CarRentNotFoundException {
        if (carRentRepository.existsById(carRentId)) {
            carRentRepository.deleteById(carRentId);
        } else {
            throw new CarRentNotFoundException();
        }
    }

    // metoda dodająca nowe uszkodzenia do pojazdu
    public void addNewDamageToCar(Long carRentId, String newDamage) throws CarNotFoundException {
        if (newDamage == null) {
            return;
        } else {
            CarRent carRent = carRentRepository.findById(carRentId).get();
            Car car = carRent.getCar();
            String oldDamage = carRent.getCar().getCarDamage();
            String newStatusDamage = oldDamage + ", " + newDamage;
            car.setCarDamage(newStatusDamage);
            carService.updateCar(car);
        }
    }

    // metoda aktualizująca przebieg pojazdu
    public void updateCarMileage(Long carRentId, Long newCarMileage) throws CarNotFoundException {
        if (newCarMileage == null) {
            return;
        } else {
            CarRent carRent = carRentRepository.findById(carRentId).get();
            Car car = carRent.getCar();
            car.setCarMileage(newCarMileage);
            carService.updateCar(car);
        }
    }

    public List<CarRent> carRentActiveStatus(final List<CarRent> carRentActive) {
        return carRentActive.stream()
                .filter(carRent -> carRent.getReturnDate().isAfter(LocalDate.now()) && carRent.getReturnHour().isAfter(LocalTime.now()))
                .collect(Collectors.toList());
    }
}
