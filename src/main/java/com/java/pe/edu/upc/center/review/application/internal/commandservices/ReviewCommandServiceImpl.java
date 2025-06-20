package com.java.pe.edu.upc.center.review.application.internal.commandservices;

import com.java.pe.edu.upc.center.review.domain.model.aggregates.Review;
import com.java.pe.edu.upc.center.review.domain.model.commands.CreateReviewCommand;
import com.java.pe.edu.upc.center.review.domain.services.ReviewCommandService;
import com.java.pe.edu.upc.center.review.infrastructure.persistence.jpa.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review handle(CreateReviewCommand command) {
        Review review = new Review(command);
        return reviewRepository.save(review);
    }
}
