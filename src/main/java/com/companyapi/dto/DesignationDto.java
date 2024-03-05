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
public class DesignationDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int designationId;
	private String name;
	
	public DesignationDto(int designationId, String name) {
		super();
		this.designationId = designationId;
		this.name = name;
	}


	@OneToMany(mappedBy = "designationDto", cascade = CascadeType.ALL)
	private List<EmployeeDto> employeeDto;
}
