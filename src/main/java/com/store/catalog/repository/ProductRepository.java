package com.store.catalog.repository;

import com.store.catalog.domain.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Product entity.
 */
@SuppressWarnings("unused")
public interface ProductRepository extends JpaRepository<Product,Long> {

	Page<Product> findByCatalogId(long id, Pageable pageable); 
	
	Page<Product> findByCatalogIdAndBrandId(Long catalogId, Long brandId, Pageable pageable);  
	
	Page<Product> findByMerchantId(Long merchantId,Pageable pageable);

}
