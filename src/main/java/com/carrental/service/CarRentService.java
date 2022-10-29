package com.carrental.service;

import com.carrental.domain.CarRent;
import com.carrental.exceptions.CarRentNotFoundException;
import com.carrental.repository.CarRentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarRentService {

    private final CarRentRepository carRentRepository;

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
}
