package com.example.glaucusTest;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<com.example.glaucusTest.dto.Number, Long> {
   
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select n from Number n where n.id=:id")
	Optional<com.example.glaucusTest.dto.Number> findNumberForWrite(@Param("id") Long id);
}
