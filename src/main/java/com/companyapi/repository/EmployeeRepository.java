package com.companyapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.companyapi.dto.EmployeeDto;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDto, Integer>{

}
