package com.store.catalog.repository;

import com.store.catalog.domain.LineItem;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the LineItem entity.
 */
@SuppressWarnings("unused")
public interface LineItemRepository extends JpaRepository<LineItem,Long> {
	
	List<LineItem> findByOrderIdOrderByProductNameAsc(long id);

}
