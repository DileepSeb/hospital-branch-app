package org.jsp.hospitalbranchapp.dao;

import java.util.Optional;

import org.jsp.hospitalbranchapp.dto.Hospital;
import org.jsp.hospitalbranchapp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository repository;
	
	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	public Hospital updateHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	public Optional<Hospital> findById(int id) {
		return repository.findById(id);
	}

}
