package com.java.pe.edu.upc.center.review.interfaces.rest.transform;

import com.java.pe.edu.upc.center.review.domain.model.commands.CreateReviewCommand;
import com.java.pe.edu.upc.center.review.interfaces.rest.resources.CreateReviewResource;

public class CreateReviewCommandFromResourceAssembler {

    public static CreateReviewCommand toCommandFromResource(CreateReviewResource resource) {
        return new CreateReviewCommand(
                resource.formUrl(),
                resource.userId()
        );
    }
}