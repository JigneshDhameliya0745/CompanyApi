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

import com.companyapi.dto.DesignationDto;
import com.companyapi.service.DesignationService;

@RestController
public class DesignationController {

	@Autowired
	private DesignationService designationService;
	
	
	@PostMapping("/adddesignation")
	public ResponseEntity<?> addDesignation(@RequestBody DesignationDto designationDto) {
		DesignationDto designation = null;
		
		try {
			designation = this.designationService.addDesignation(designationDto);
			System.out.println(designationDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(designation);
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Enter Valid Designation Details!");
		}
	}
	
	
	@PutMapping("/updatedesignation/{Id}")
	public ResponseEntity<?> updateDesignation(@RequestBody DesignationDto designationDto, @PathVariable("Id") int designationId) {
		DesignationDto designation = null;
		try {
			this.designationService.updateDesignation(designationDto, designationId);
			return ResponseEntity.status(HttpStatus.OK).body(designation);
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid DesignationId for Update Designation Record!");
		}
	}
	
	
	@DeleteMapping("/deletedesignation/{Id}")
	public ResponseEntity<?> deleteDesignation(@PathVariable("Id") int designationId) {
		try {
			this.designationService.deleteDesignation(designationId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
//			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid DesignationId for Delete Designation Record!");
		}
	}
	
	
	@GetMapping("/getdesignationwithemployee/{Id}")
	public ResponseEntity<?> getDesignation(@PathVariable("Id") int designationId) {
		Optional<DesignationDto> designationDto = designationService.getDesignationById(designationId);
		if (designationDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Valid DesignationId for get Designation Details!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(designationDto);
	}
	
	@GetMapping("/getdesignationwithemployee")
	public ResponseEntity<List<DesignationDto>> getDesignation() {
		List<DesignationDto> list = designationService.getDesignationWithEmployee();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	
	@GetMapping("/getdesignations")
	public ResponseEntity<List<DesignationDto>> getDesignations() {
		List<DesignationDto> list = designationService.getAllDesignations();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
}
