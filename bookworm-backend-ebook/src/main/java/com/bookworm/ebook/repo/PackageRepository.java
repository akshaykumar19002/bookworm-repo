package com.bookworm.ebook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookworm.ebook.entity.PackageEntity;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer>{

	@Query("FROM PackageEntity pkg where pkg.userId = ?1 and pkg.endDate > ?2")
	List<PackageEntity> findByUserId(Integer userId, Long endDate);
	
}
