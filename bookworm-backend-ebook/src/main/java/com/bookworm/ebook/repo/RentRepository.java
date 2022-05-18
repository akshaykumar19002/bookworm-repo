package com.bookworm.ebook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookworm.ebook.entity.RentEntity;

public interface RentRepository extends JpaRepository<RentEntity, Integer>{
	
	RentEntity save(RentEntity ref);
	
	List<RentEntity> findByUserId(Integer userId);
	
	void deleteById(Integer rentId);
	
	List<RentEntity> findByUserIdAndBookId(Integer userId, Integer bookdId);
}
