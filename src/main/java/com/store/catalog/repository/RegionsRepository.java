package com.store.catalog.repository;

import com.store.catalog.domain.Regions;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Regions entity.
 */
@SuppressWarnings("unused")
public interface RegionsRepository extends JpaRepository<Regions,Long> {
	
	List<Regions> findByParentId(Integer parentId);

}
