package br.com.kopz.elasticsearch.services.impl;

import br.com.kopz.elasticsearch.domain.GeoLocation;
import br.com.kopz.elasticsearch.domain.entities.Address;
import br.com.kopz.elasticsearch.services.GeoLocationService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGeoLocationService implements GeoLocationService {

  // RANDOM LOCATION IN CITY OF SAO PAULO
  private static final float MIN_LATITUDE = -24.01f;
  private static final float MAX_LATITUDE = -23.35f;
  private static final float MAX_LONGITUDE = -46.36f;
  private static final float MIN_LONGITUDE = -46.83f;

  @Override
  public GeoLocation geoLocate(Address address) {
    var random = new Random();
    double latitude = MIN_LATITUDE + random.nextDouble() * (MAX_LATITUDE - MIN_LATITUDE);
    double longitude = MIN_LONGITUDE + random.nextDouble() * (MAX_LONGITUDE - MIN_LONGITUDE);

    return GeoLocation.builder()
        .latitude(latitude)
        .longitude(longitude)
        .build();
  }
}
