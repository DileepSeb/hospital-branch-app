package org.jsp.hospitalbranchapp.service;

import java.util.Optional;

import org.jsp.hospitalbranchapp.dao.HospitalDao;
import org.jsp.hospitalbranchapp.dto.Hospital;
import org.jsp.hospitalbranchapp.dto.ResponseStructure;
import org.jsp.hospitalbranchapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>>saveHospital(Hospital hospital){
		ResponseStructure<Hospital>structure=new ResponseStructure<>();
		structure.setData(dao.saveHospital(hospital));
		structure.setMessage("Hospital created");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Hospital>>updateHospital(Hospital hospital){
		ResponseStructure<Hospital>structure=new ResponseStructure<>();
		structure.setData(dao.updateHospital(hospital));
		structure.setMessage("Hospital created");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Hospital>>findById(int id){
		ResponseStructure<Hospital>structure=new ResponseStructure<>();
		Optional<Hospital>recHospital=dao.findById(id);
		if(recHospital.isPresent()) {
			structure.setData(recHospital.get());
			structure.setMessage("Hospital is founded");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

}
