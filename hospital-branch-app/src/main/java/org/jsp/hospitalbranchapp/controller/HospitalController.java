package org.jsp.hospitalbranchapp.controller;

import org.jsp.hospitalbranchapp.dto.Hospital;
import org.jsp.hospitalbranchapp.dto.ResponseStructure;
import org.jsp.hospitalbranchapp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
	@Autowired
	private HospitalService service;
	
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>>saveHospital(@RequestBody Hospital hospital){
		return service.saveHospital(hospital);
	}
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>>updateHospital(@RequestBody Hospital hospital){
		return service.updateHospital(hospital);
	}
	@GetMapping("/hospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>>findById(@PathVariable int id){
		return service.findById(id);
	}

}
