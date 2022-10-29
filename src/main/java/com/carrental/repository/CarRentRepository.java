package com.carrental.repository;

import com.carrental.domain.CarRent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentRepository extends CrudRepository<CarRent, Long> {

    public List<CarRent> findAll();
}
