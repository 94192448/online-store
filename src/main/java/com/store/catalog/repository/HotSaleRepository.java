package com.store.catalog.repository;

import com.store.catalog.domain.HotSale;

import com.store.catalog.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the HotSale entity.
 */
@SuppressWarnings("unused")
public interface HotSaleRepository extends JpaRepository<HotSale,Long> {

	//Page<HotSale> findByTypeIdAndItemId(String typeId, String itemId, Pageable pageable);

	@Query("select p from Product p,HotSale h where p.id=h.product.id and h.typeId=?1 and h.itemId=?2")
	Page<Product> findHostProduct(String typeId, String itemId, Pageable pageable);

}
