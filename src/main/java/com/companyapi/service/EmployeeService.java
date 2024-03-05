package com.companyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyapi.dto.EmployeeDto;
import com.companyapi.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		
		EmployeeDto employee = employeeRepository.save(employeeDto);
		return employee;
	}
	
	
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, int employeeId)
	{
		employeeDto.setEmployeeId(employeeId);
		EmployeeDto employee = employeeRepository.save(employeeDto);
		return employee;
	}
	
	
	public void deleteEmployee(int employeeId)
	{
		employeeRepository.deleteById(employeeId);
	}
	
	public Optional<EmployeeDto> getEmployeeById(int employeeId)
	{
		Optional<EmployeeDto> employee = null;
		try
		{
			employee = this.employeeRepository.findById(employeeId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employee;
	}
	
	
	public List<EmployeeDto> getAllEmployees()
	{
		List<EmployeeDto> list = (List<EmployeeDto>)this.employeeRepository.findAll();
		return list;
	}
	
}
