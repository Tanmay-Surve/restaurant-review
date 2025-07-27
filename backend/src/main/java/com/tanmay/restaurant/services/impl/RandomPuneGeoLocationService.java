package com.tanmay.restaurant.services.impl;

import com.tanmay.restaurant.domain.GeoLocation;
import com.tanmay.restaurant.domain.entities.Address;
import com.tanmay.restaurant.services.GeoLocationService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomPuneGeoLocationService implements GeoLocationService {

    private static final float MIN_LATITUDE = 18.457f;
    private static final float MAX_LATITUDE = 18.634f;
    private static final float MIN_LONGITUDE = 73.763f;
    private static final float MAX_LONGITUDE = 73.947f;


    @Override
    public GeoLocation geoLocate(Address address) {
        Random random = new Random();
        double latitude = MIN_LATITUDE + random.nextDouble() * (MAX_LATITUDE - MIN_LATITUDE);
        double longitude = MIN_LONGITUDE + random.nextDouble() * (MAX_LONGITUDE - MIN_LONGITUDE);

        return GeoLocation.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
