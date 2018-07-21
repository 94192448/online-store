package com.store.catalog.repository;

import com.store.catalog.domain.CustomerAccount;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the CustomerAccount entity.
 */
@SuppressWarnings("unused")
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,Long> {

}
