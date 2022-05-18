package com.bookworm.ebook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookworm.ebook.entity.BillingEntity;
import com.bookworm.ebook.entity.EbookEntity;

public interface BillingRepository extends JpaRepository<BillingEntity, Integer>{
	
	List<BillingEntity> findByUserIdAndBookIdAndAction(Integer userId, EbookEntity bookId, String action);
	
	List<BillingEntity> findByUserId(Integer userId);
	
	List<BillingEntity> findByUserIdAndAction(Integer userId, String action);
	
}
