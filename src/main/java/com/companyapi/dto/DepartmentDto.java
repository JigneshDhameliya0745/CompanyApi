package com.companyapi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DepartmentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;
	private String name;
	
	public DepartmentDto(int departmentId, String name) {
		super();
		this.departmentId = departmentId;
		this.name = name;
	}
	
	@OneToMany(mappedBy = "departmentDto", cascade = CascadeType.ALL)
	private List<EmployeeDto> employeeDto;
	
}
