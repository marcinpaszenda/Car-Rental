package com.carrental.mapper;

import com.carrental.domain.Car;
import com.carrental.domain.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarMapper {

    public Car mapToCar(final CarDto carDto) {
        return new Car(
                carDto.getCarId(),
                carDto.getCarBrand(),
                carDto.getRegistrationNumber(),
                carDto.getCarMileage(),
                carDto.getVinNumber(),
                carDto.getCarDamage()
        );
    }

    public CarDto mapToCarDto(final Car car) {
        return new CarDto(
                car.getCarId(),
                car.getCarBrand(),
                car.getRegistrationNumber(),
                car.getCarMileage(),
                car.getVinNumber(),
                car.getCarDamage()
        );
    }

    public List<CarDto> mapToCarDtoList(final List<Car> cars) {
        return cars.stream()
                .map(this::mapToCarDto)
                .collect(Collectors.toList());
    }
}
