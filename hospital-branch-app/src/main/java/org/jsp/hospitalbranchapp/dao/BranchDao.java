package org.jsp.hospitalbranchapp.dao;


import java.util.Optional;

import org.jsp.hospitalbranchapp.dto.Branch;
import org.jsp.hospitalbranchapp.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository repository;
	
	public Branch saveBranch(Branch branch) {
		return repository.save(branch);
	}
	
	public Branch updateBranch(Branch branch) {
		return repository.save(branch);
	}
	public Optional<Branch> findBranch(int hospital_id) {
		return repository.findBranch(hospital_id);
	}
	public Optional<Branch> findName(String name) {
		return repository.findName(name);
	}
	

}
