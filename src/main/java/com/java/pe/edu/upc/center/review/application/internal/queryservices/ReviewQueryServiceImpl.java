package com.java.pe.edu.upc.center.review.application.internal.queryservices;


import com.java.pe.edu.upc.center.review.domain.model.aggregates.Review;
import com.java.pe.edu.upc.center.review.domain.model.queries.GetAllReviewQuery;
import com.java.pe.edu.upc.center.review.domain.services.ReviewQueryService;
import com.java.pe.edu.upc.center.review.infrastructure.persistence.jpa.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> handle(GetAllReviewQuery query) {
        return reviewRepository.findAll();
    }
}
