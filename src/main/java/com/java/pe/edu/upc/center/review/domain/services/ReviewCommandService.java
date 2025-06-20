package com.java.pe.edu.upc.center.review.domain.services;

import com.java.pe.edu.upc.center.review.domain.model.aggregates.Review;
import com.java.pe.edu.upc.center.review.domain.model.commands.CreateReviewCommand;

public interface ReviewCommandService {
    Review handle(CreateReviewCommand command);
}
