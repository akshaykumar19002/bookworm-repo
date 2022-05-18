package com.bookworm.ebook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookworm.ebook.entity.EbookEntity;

public interface EbookRepository extends JpaRepository<EbookEntity, Integer>{
	
	EbookEntity save(EbookEntity ebook);

	@Query(value="SELECT * FROM ebooks e WHERE e.booktitle like ?1", nativeQuery = true)
	List<EbookEntity> findByBooktitle(String searchText);

}
