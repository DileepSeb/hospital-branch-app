package org.jsp.hospitalbranchapp.controller;


import org.jsp.hospitalbranchapp.dto.Branch;
import org.jsp.hospitalbranchapp.dto.ResponseStructure;
import org.jsp.hospitalbranchapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService service;
	
	@PostMapping("/branches/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>>saveBranch(@RequestBody  Branch branch,@PathVariable int hospital_id){
		return service.saveBranch(branch, hospital_id);
	}
	@PutMapping("/branches/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>>updateBranch(@RequestBody  Branch branch,@PathVariable int hospital_id){
		return service.updateBranch(branch, hospital_id);
	}
	@GetMapping("/branches/findbranch/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>>findBranch(@PathVariable int hospital_id){
		return service.findBranch(hospital_id);
	}
	@PostMapping("/branches/findname")
	public ResponseEntity<ResponseStructure<Branch>>findName(@RequestParam String name){
		return service.findName(name);
	}

}
