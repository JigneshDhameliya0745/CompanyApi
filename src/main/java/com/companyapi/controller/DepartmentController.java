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

import com.companyapi.dto.DepartmentDto;
import com.companyapi.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping("/adddepartment")
	public ResponseEntity<?> addDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto department = null;
		try {
			department = this.departmentService.addDepartment(departmentDto);
			System.out.println(departmentDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(department);
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Enter Valid Department Details!");
		}
	}
	
	
	@PutMapping("/updatedepartment/{Id}")
	public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable("Id") int departmentId) {
		DepartmentDto department = null;
		try {
			this.departmentService.updateDepartment(departmentDto, departmentId);
			return ResponseEntity.status(HttpStatus.OK).body(department);
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid DepartmentId for Update Department Record!");
		}
	}
	
	
	@DeleteMapping("/deletedepartment/{Id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("Id") int departmentId) {
		try {
			this.departmentService.deleteDepartment(departmentId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid DepartmentId for Delete Department Record!");
		}
	}
	
	
	@GetMapping("/getdepartmentwithemployee/{Id}")
	public ResponseEntity<?> getDepartment(@PathVariable("Id") int departmentId) {
		Optional<DepartmentDto> departmentDto = departmentService.getDepartmentById(departmentId);
		if (departmentDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid DepartmentId for get Department Details!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
	}
	
	
	@GetMapping("/getdepartmentwithemployee")
	public ResponseEntity<List<DepartmentDto>> getDepartment() {
		List<DepartmentDto> list = departmentService.getDepartmentWithEmployee();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	
	@GetMapping("/getdepartments")
	public ResponseEntity<List<DepartmentDto>> getDepartments() {
		List<DepartmentDto> list = departmentService.getAllDepartments();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
//		List<DepartmentDto> list = new ArrayList<>();
//				list = listDto.getEmployeeDto().remove(employeeDto);

//		List<EmployeeDto> listEmp = new ArrayList<>();
//		listDept.forEach(object -> {
//			listEmp.removeAll(listEmp);
//		});
//		return listDto;
		
//		if (list.size() <= 0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(list);
}
