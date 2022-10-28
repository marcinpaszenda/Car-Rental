package com.carrental.repository;

import com.carrental.domain.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {

    List<Driver> findAll();
}
