package com.tanmay.restaurant.services;

import com.tanmay.restaurant.domain.GeoLocation;
import com.tanmay.restaurant.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
