package com.java.pe.edu.upc.center.review.interfaces.rest;

import com.java.pe.edu.upc.center.review.domain.model.aggregates.Review;
import com.java.pe.edu.upc.center.review.domain.model.queries.GetAllReviewQuery;
import com.java.pe.edu.upc.center.review.domain.services.ReviewCommandService;
import com.java.pe.edu.upc.center.review.domain.services.ReviewQueryService;
import com.java.pe.edu.upc.center.review.interfaces.rest.resources.CreateReviewResource;
import com.java.pe.edu.upc.center.review.interfaces.rest.resources.ReviewResource;
import com.java.pe.edu.upc.center.review.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import com.java.pe.edu.upc.center.review.interfaces.rest.transform.ReviewResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/review")
@Tag(name="Review", description = "Review Management Endpoints")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ReviewController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    public ReviewController(ReviewCommandService reviewCommandService, ReviewQueryService reviewQueryService) {
        this.reviewCommandService = reviewCommandService;
        this.reviewQueryService = reviewQueryService;
    }

    @PostMapping
    public ResponseEntity<ReviewResource> createReview(@RequestBody CreateReviewResource resource) throws Exception {
        var createReviewCommand = CreateReviewCommandFromResourceAssembler.toCommandFromResource(resource);

        Review review = reviewCommandService.handle(createReviewCommand);

        return new ResponseEntity<>(ReviewResourceFromEntityAssembler.toResourceFromEntity(review), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ReviewResource>> getAllReview() {
        GetAllReviewQuery getAllReviewQuery = new GetAllReviewQuery();

        List<Review> reviews = reviewQueryService.handle(getAllReviewQuery);

        return new ResponseEntity<>(reviews.stream().map(ReviewResourceFromEntityAssembler::toResourceFromEntity).toList(), HttpStatus.OK);
    }
}
