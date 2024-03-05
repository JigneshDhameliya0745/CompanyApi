package com.companyapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.companyapi.dto.DesignationDto;

@Repository
@EnableJpaRepositories
public interface DesignationRepository extends CrudRepository<DesignationDto, Integer>{

	@Query("select new com.companyapi.dto.DesignationDto(designationId, name) from DesignationDto")
	public List<DesignationDto> getAllDesignations();
}
