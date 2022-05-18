package com.bookworm.ebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookworm.ebook.entity.LendEntity;

public interface LendRepository extends JpaRepository<LendEntity, Integer>{

	LendEntity save(LendEntity lend);
	
}
