package com.store.catalog.repository;

import com.store.catalog.domain.CustomerCoupon;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the CustomerCoupon entity.
 */
@SuppressWarnings("unused")
public interface CustomerCouponRepository extends JpaRepository<CustomerCoupon,Long> {

}
