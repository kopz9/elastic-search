package br.com.kopz.elasticsearch.services;

import br.com.kopz.elasticsearch.domain.RestaurantCreateUpdateRequest;
import br.com.kopz.elasticsearch.domain.entities.Restaurant;

public interface RestaurantService {
  Restaurant createRestaurant(RestaurantCreateUpdateRequest request);
}
