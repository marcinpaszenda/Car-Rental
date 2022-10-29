package com.carrental.repository;

import com.carrental.domain.CarReturnReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarReturnReportRepository extends CrudRepository<CarReturnReport,Long> {

}
