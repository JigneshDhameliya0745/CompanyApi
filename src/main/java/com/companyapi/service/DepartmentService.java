package com.companyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyapi.dto.DepartmentDto;
import com.companyapi.dto.EmployeeDto;
import com.companyapi.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	List<EmployeeDto> employeeDtos;
	public DepartmentDto addDepartment(DepartmentDto departmentDto) {

		DepartmentDto department = departmentRepository.save(departmentDto);
		return department;
	}
	
	
	public void updateDepartment(DepartmentDto departmentDto, int departmentId)
	{
		departmentDto.setDepartmentId(departmentId);
		departmentRepository.save(departmentDto);
	}
	
	
	public void deleteDepartment(int departmentId)
	{
		departmentRepository.deleteById(departmentId);
	}
	
	
	public Optional<DepartmentDto> getDepartmentById(int departmentId)
	{
		Optional<DepartmentDto> department = null;
		try
		{
			department = this.departmentRepository.findById(departmentId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return department;
	}
	
	
	public List<DepartmentDto> getDepartmentWithEmployee()
	{
		List<DepartmentDto> list = (List<DepartmentDto>)this.departmentRepository.findAll();
		return list;
	}
	
	
	public List<DepartmentDto> getAllDepartments()
	{
		List<DepartmentDto> list = (List<DepartmentDto>)this.departmentRepository.getAllDepartments();
		if(list.contains(employeeDtos))
		{
			employeeDtos.remove(2);
			return list;
		}
		return list;
	}

}
