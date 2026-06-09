package br.com.kopz.elasticsearch.services;

import br.com.kopz.elasticsearch.domain.ReviewCreateUpdateRequest;
import br.com.kopz.elasticsearch.domain.entities.Review;
import br.com.kopz.elasticsearch.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewService {

  Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review);

  Page<Review> listReviews(String restaurantId, Pageable pageable);

  Optional<Review> getReview(String restaurantId, String reviewId);

  Review updateReview(User author, String restaurantId, String reviewId, ReviewCreateUpdateRequest reviewUpdateRequest);

  void deleteReview(String restaurantId, String reviewId);

}
