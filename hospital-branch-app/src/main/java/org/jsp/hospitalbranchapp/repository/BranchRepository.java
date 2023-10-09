package org.jsp.hospitalbranchapp.repository;

import java.util.Optional;

import org.jsp.hospitalbranchapp.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch, Integer>{
	@Query("select b from Branch b where b.hospital.id=?1")
	Optional<Branch>findBranch(int hospital_id);
	
	@Query("select b from Branch b where b.hospital.name=?1")
	Optional<Branch>findName(String name);

}
