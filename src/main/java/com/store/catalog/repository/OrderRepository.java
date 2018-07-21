package com.store.catalog.repository;

import com.store.catalog.domain.Order;
import com.store.catalog.domain.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Order entity.
 */
@SuppressWarnings("unused")
public interface OrderRepository extends JpaRepository<Order,Long> {
	
	Page<Order> findByAccountId(int accountId, Pageable pageable);
	
	
	@Query("SELECT a from Order a ,LineItem b where a.id=b.orderId and b.product.merchantId=?1")
	Page<Order> findByMerchantId(Long merchantId, Pageable pageable); 

}
