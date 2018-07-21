package com.store.catalog.repository;

import com.store.catalog.domain.Address;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Address entity.
 */
@SuppressWarnings("unused")
public interface AddressRepository extends JpaRepository<Address,Long> {
	
	List<Address> findByAccountId(Long id); 

}
