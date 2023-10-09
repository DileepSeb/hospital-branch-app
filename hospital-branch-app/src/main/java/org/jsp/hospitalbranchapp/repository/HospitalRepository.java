package org.jsp.hospitalbranchapp.repository;

import org.jsp.hospitalbranchapp.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
