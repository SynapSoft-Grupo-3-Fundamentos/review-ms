package com.java.pe.edu.upc.center.review.infrastructure.persistence.jpa.repositories;

import com.java.pe.edu.upc.center.review.domain.model.aggregates.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
