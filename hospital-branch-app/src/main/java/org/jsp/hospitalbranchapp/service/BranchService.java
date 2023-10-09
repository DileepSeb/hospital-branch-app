package org.jsp.hospitalbranchapp.service;

import java.util.Optional;

import org.jsp.hospitalbranchapp.dao.BranchDao;
import org.jsp.hospitalbranchapp.dao.HospitalDao;
import org.jsp.hospitalbranchapp.dto.Branch;
import org.jsp.hospitalbranchapp.dto.Hospital;
import org.jsp.hospitalbranchapp.dto.ResponseStructure;
import org.jsp.hospitalbranchapp.exception.IdNotFoundException;
import org.jsp.hospitalbranchapp.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private BranchDao dao;
	@Autowired
	private HospitalDao hDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hospital_id){
		Optional<Hospital>recHospital=hDao.findById(hospital_id);
		ResponseStructure<Branch>structure=new ResponseStructure<>();
		if(recHospital.isPresent()) {
			Hospital h=recHospital.get();
			h.getBranches().add(branch);
			branch.setHospital(h);
			hDao.updateHospital(h);
			dao.saveBranch(branch);
			structure.setData(branch);
			structure.setMessage("Branch added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
			}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int hospital_id){
		Optional<Hospital>recHospital=hDao.findById(hospital_id);
		ResponseStructure<Branch>structure=new ResponseStructure<>();
		if(recHospital.isPresent()) {
			
			branch.setHospital(recHospital.get());
			
			dao.saveBranch(branch);
			structure.setData(branch);
			structure.setMessage("Branch added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
			}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Branch>>findBranch(int hospital_id){
		Optional<Branch> recBranch=dao.findBranch(hospital_id);
		ResponseStructure<Branch>structure=new ResponseStructure<>();
		if(recBranch.isPresent()) {
			structure.setData(recBranch.get());
			structure.setMessage("Braches founded");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Branch>>findName(String name){
		Optional<Branch> recBranch=dao.findName(name);
		ResponseStructure<Branch>structure=new ResponseStructure<>();
		if(recBranch.isPresent()) {
			structure.setData(recBranch.get());
			structure.setMessage("Braches founded");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}
}
