package com.store.catalog.repository;

import com.store.catalog.domain.ShoppingCart;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the ShoppingCart entity.
 */
@SuppressWarnings("unused")
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
	
	List<ShoppingCart> findByAccountIdOrderByProductNameAsc(int accountId);
	
	ShoppingCart findByProductIdAndInSplit(Long id,Boolean inSplit);

}
