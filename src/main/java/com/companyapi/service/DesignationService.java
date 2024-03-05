package com.companyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyapi.dto.DesignationDto;
import com.companyapi.repository.DesignationRepository;

@Service
public class DesignationService {

	@Autowired
	private DesignationRepository designationRepository;
	
	public DesignationDto addDesignation(DesignationDto designationDto) {
		
		DesignationDto designation = designationRepository.save(designationDto);
		return designation;
	}
	
	
	public void updateDesignation(DesignationDto designationDto, int designationId)
	{
		designationDto.setDesignationId(designationId);
		designationRepository.save(designationDto);
	}
	
	
	public void deleteDesignation(int designationId)
	{
		designationRepository.deleteById(designationId);
	}
	
	
	public Optional<DesignationDto> getDesignationById(int designationId)
	{
		Optional<DesignationDto> designation = null;
		try
		{
			designation = this.designationRepository.findById(designationId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return designation;
	}
	
	
	public List<DesignationDto> getDesignationWithEmployee()
	{
		List<DesignationDto> list = (List<DesignationDto>)this.designationRepository.findAll();
		return list;
	}
	
	
	public List<DesignationDto> getAllDesignations()
	{
		List<DesignationDto> list = (List<DesignationDto>)this.designationRepository.getAllDesignations();
		return list;
	}
//	public List<String> getAllDesignations()
//	{
//		List<String> list = new LinkedList<String>();
//		List<DesignationDto> dtoList = (List<DesignationDto>)this.designationRepository.findAll();
//		for (DesignationDto designationDto : dtoList) {
//			list.add("departmentId:" + " " + designationDto.getDesignationId());
//			list.add("departmentName:" + " " + designationDto.getName());
//		}
//		return list;
//	}
}
