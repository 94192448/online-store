package com.store.catalog.repository;

import com.store.catalog.domain.SysServiceCode;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the SysServiceCode entity.
 */
@SuppressWarnings("unused")
public interface SysServiceCodeRepository extends JpaRepository<SysServiceCode,Long> {

	List<SysServiceCode> findByCode(String code); 

}
