package br.com.kopz.elasticsearch.services;

import br.com.kopz.elasticsearch.domain.RestaurantCreateUpdateRequest;
import br.com.kopz.elasticsearch.domain.entities.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantService {
  Restaurant createRestaurant(RestaurantCreateUpdateRequest request);

  Page<Restaurant> searchRestaurants(
      String query,
      Float minRating,
      Float latitude,
      Float longitude,
      Float radius,
      Pageable pageable
  );
}
