package com.companyapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyapi.dto.EmployeeDto;
import com.companyapi.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/addemployee")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto employee = null;
		try {
			employee = this.employeeService.addEmployee(employeeDto);
			System.out.println(employeeDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(employee);
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Enter Valid DepartmentId or DesignationId!");
		}
	}
	
	
	@PutMapping("/updateemployee/{Id}")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("Id") int employeeId) {
		EmployeeDto employee = null;
		try {
			employee = this.employeeService.updateEmployee(employeeDto, employeeId);
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid DepartmentId or DesignationId for Update Employee Record!");
		}
	}
	
	
	@DeleteMapping("/deleteemployee/{Id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("Id") int employeeId) {
		try {
			this.employeeService.deleteEmployee(employeeId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid EmployeeId for Delete Employee Record!");
		}
	}
	
	
	@GetMapping("/getemployee/{Id}")
	public ResponseEntity<?> getEmployee(@PathVariable("Id") int employeeId) {
		Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(employeeId);
		if (employeeDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid EmployeeId for get Employee Details!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
	}
	
	
	@GetMapping("/getemployees")
	public ResponseEntity<List<EmployeeDto>> getEmployees() {
		List<EmployeeDto> list = employeeService.getAllEmployees();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
}
