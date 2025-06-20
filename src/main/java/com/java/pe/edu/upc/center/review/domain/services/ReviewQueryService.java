package com.java.pe.edu.upc.center.review.domain.services;

import com.java.pe.edu.upc.center.review.domain.model.aggregates.Review;
import com.java.pe.edu.upc.center.review.domain.model.queries.GetAllReviewQuery;

import java.util.List;

public interface ReviewQueryService {
    List<Review> handle(GetAllReviewQuery query);
}
