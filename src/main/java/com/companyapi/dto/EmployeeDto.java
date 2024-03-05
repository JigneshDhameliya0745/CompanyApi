package com.companyapi.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EmployeeDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String firstname;
	private String lastname;
	private double salary;
	private Date dob;
	private String address;
	private int departmentId;
	private int designationId;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
	private DepartmentDto departmentDto;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "designationId", referencedColumnName = "designationId", insertable = false, updatable = false)
	private DesignationDto designationDto;
	
}
