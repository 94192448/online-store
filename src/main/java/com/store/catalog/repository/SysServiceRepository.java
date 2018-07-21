package com.store.catalog.repository;

import com.store.catalog.domain.SysService;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the SysService entity.
 */
@SuppressWarnings("unused")
public interface SysServiceRepository extends JpaRepository<SysService,Long> {

}
