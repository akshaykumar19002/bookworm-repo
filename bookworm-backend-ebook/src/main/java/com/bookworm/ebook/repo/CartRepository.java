package com.bookworm.ebook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bookworm.ebook.entity.CartEntity;
import com.bookworm.ebook.entity.EbookEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer>{

	List<CartEntity> findByUserIdAndBookIdAndAction(Integer userId, EbookEntity bookId, String action);
	
	List<CartEntity> findByUserId(Integer userId);

	@Modifying
	@Query(value="DELETE FROM CartEntity crt WHERE crt.userId = ?1")
	void clearCart(Integer userId);
	
}
