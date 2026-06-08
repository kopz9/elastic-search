package br.com.kopz.elasticsearch.services;

import br.com.kopz.elasticsearch.domain.GeoLocation;
import br.com.kopz.elasticsearch.domain.entities.Address;

public interface GeoLocationService {

  GeoLocation geoLocate(Address address);

}
