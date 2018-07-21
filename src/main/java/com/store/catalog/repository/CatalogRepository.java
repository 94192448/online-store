package com.store.catalog.repository;

import com.store.catalog.domain.Catalog;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Catalog entity.
 */
@SuppressWarnings("unused")
public interface CatalogRepository extends JpaRepository<Catalog,Long> {

	List<Catalog> findByParentIdOrderByOrdernumDesc(int id); 

}
