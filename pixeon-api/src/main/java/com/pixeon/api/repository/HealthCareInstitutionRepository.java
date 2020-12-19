package com.pixeon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixeon.api.model.HealthCareInstitution;

/**
 * @author Gerusa
 *
 */
public interface HealthCareInstitutionRepository  extends JpaRepository<HealthCareInstitution, Long> {
	
	HealthCareInstitution findByCnpj(String cnpj);

}
