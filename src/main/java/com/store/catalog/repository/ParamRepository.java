package com.store.catalog.repository;

import com.store.catalog.domain.Param;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Param entity.
 */
@SuppressWarnings("unused")
public interface ParamRepository extends JpaRepository<Param,Long> {

	Page<Param> findByTypeId(int typeId,Pageable pageable); 

}
