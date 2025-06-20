package com.java.pe.edu.upc.center.review.domain.model.aggregates;

import com.java.pe.edu.upc.center.review.domain.model.commands.CreateReviewCommand;
import com.java.pe.edu.upc.center.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "reviews")
public class Review extends AuditableAbstractAggregateRoot<Review> {

    @Column(nullable = false)
    private String formUrl;

    @Column(nullable = false)
    private Long userId;

    public Review() {}

    public Review(String formUrl, Long userId) {
        this.formUrl = formUrl;
        this.userId = userId;
    }

    public Review(CreateReviewCommand command) {
        this.formUrl = command.formUrl();
        this.userId = command.userId();
    }

}
