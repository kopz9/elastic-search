package br.com.kopz.elasticsearch.mappers;

import br.com.kopz.elasticsearch.domain.RestaurantCreateUpdateRequest;
import br.com.kopz.elasticsearch.domain.dtos.*;
import br.com.kopz.elasticsearch.domain.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

@Mapper(componentModel = "sppring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

  RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto);

  RestaurantDto toRestaurantDto(Restaurant restaurant);

  @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
  RestaurantSummaryDto toSummaryDto(Restaurant restaurant);

  @Named("populateTotalReviews")
  default Integer populateTotalReviews(List<ReviewDto> reviews) {
    return reviews.size();
  }

  @Mapping(target = "latitude", expression = "java(geoPoint.getLat()")
  @Mapping(target = "longitude", expression = "java(geoPoint.getLon()")
  GeoPointDto toGeoPointDto(GeoPoint geoPoint);
}
