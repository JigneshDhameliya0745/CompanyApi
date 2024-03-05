package com.companyapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.companyapi.dto.DepartmentDto;

@Repository
@EnableJpaRepositories
public interface DepartmentRepository extends CrudRepository<DepartmentDto, Integer>{

	@Query("select new com.companyapi.dto.DepartmentDto(departmentId, name) from DepartmentDto")
	public List<DepartmentDto> getAllDepartments();
}
