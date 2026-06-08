package br.com.kopz.elasticsearch.controllers;

import br.com.kopz.elasticsearch.domain.RestaurantCreateUpdateRequest;
import br.com.kopz.elasticsearch.domain.dtos.RestaurantCreateUpdateRequestDto;
import br.com.kopz.elasticsearch.domain.dtos.RestaurantDto;
import br.com.kopz.elasticsearch.domain.entities.Restaurant;
import br.com.kopz.elasticsearch.mappers.RestaurantMapper;
import br.com.kopz.elasticsearch.services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
