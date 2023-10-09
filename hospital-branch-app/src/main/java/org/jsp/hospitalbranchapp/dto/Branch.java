package org.jsp.hospitalbranchapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(unique=true,nullable=false)
	private String email;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	
	private int pincode;
	@Column(unique=true,nullable=false)
	private long phone;
	@Column(nullable=false)
	private String city;
	@ManyToOne
	@JoinColumn(name="hospitl_id")
	@JsonIgnore
	private Hospital hospital;

}
