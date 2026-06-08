package br.com.kopz.elasticsearch.controllers;

import br.com.kopz.elasticsearch.domain.RestaurantCreateUpdateRequest;
import br.com.kopz.elasticsearch.domain.dtos.RestaurantCreateUpdateRequestDto;
import br.com.kopz.elasticsearch.domain.dtos.RestaurantDto;
import br.com.kopz.elasticsearch.domain.dtos.RestaurantSummaryDto;
import br.com.kopz.elasticsearch.domain.entities.Restaurant;
import br.com.kopz.elasticsearch.mappers.RestaurantMapper;
import br.com.kopz.elasticsearch.services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
@RestController
public class RestaurantController {

  private final RestaurantService restaurantService;
  private final RestaurantMapper restaurantMapper;

  @PostMapping
  public ResponseEntity<RestaurantDto> createRestaurant(
      @Valid @RequestBody RestaurantCreateUpdateRequestDto request
  ) {
    RestaurantCreateUpdateRequest restaurantCreateUpdateRequest = restaurantMapper.toRestaurantCreateUpdateRequest(request);

    Restaurant restaurant = restaurantService.createRestaurant(restaurantCreateUpdateRequest);

    RestaurantDto createdRestaurantDto = restaurantMapper.toRestaurantDto(restaurant);

    return ResponseEntity.ok(createdRestaurantDto);
  }

  @GetMapping
  public Page<RestaurantSummaryDto> searchRestaurants(
      @RequestParam(required = false) String q,
      @RequestParam(required = false) Float minRating,
      @RequestParam(required = false) Float latitude,
      @RequestParam(required = false) Float longitude,
      @RequestParam(required = false) Float radius,
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "20") int size
  ) {
    Page<Restaurant> searchResults = restaurantService.searchRestaurants(
        q, minRating, latitude, longitude, radius, PageRequest.of(page - 1, size)
    );

    return searchResults.map(restaurantMapper::toSummaryDto);
  }


}
