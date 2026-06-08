package br.com.kopz.elasticsearch.mappers;

import br.com.kopz.elasticsearch.domain.RestaurantCreateUpdateRequest;
import br.com.kopz.elasticsearch.domain.dtos.GeoPointDto;
import br.com.kopz.elasticsearch.domain.dtos.RestaurantDto;
import br.com.kopz.elasticsearch.domain.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Mapper(componentModel = "sppring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

  RestaurantCreateUpdateRequest  toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequest restaurantCreateUpdateRequest);

  RestaurantDto  toRestaurantDto(Restaurant restaurant);

  @Mapping(target = "latitude", expression = "java(geoPoint.getLat()")
  @Mapping(target = "longitude", expression = "java(geoPoint.getLon()")
  GeoPointDto toGeoPointDto(GeoPoint geoPoint);
}
