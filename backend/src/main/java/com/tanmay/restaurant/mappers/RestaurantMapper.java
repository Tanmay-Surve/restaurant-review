package com.tanmay.restaurant.mappers;

import com.tanmay.restaurant.domain.RestaurantCreateUpdateRequest;
import com.tanmay.restaurant.domain.dtos.GeoPointDto;
import com.tanmay.restaurant.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.tanmay.restaurant.domain.dtos.RestaurantDto;
import com.tanmay.restaurant.domain.dtos.RestaurantSummaryDto;
import com.tanmay.restaurant.domain.entities.Restaurant;
import com.tanmay.restaurant.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantSummaryDto toSummaryDto(Restaurant restaurant);

    @Named("populateTotalReviews")
    default Integer populateTotalReviews(List<Review> reviews) {
        return (reviews != null) ? reviews.size() : 0;
    }


    @Mapping(target = "latitude", expression = "java(geoPoint.getLat())")
    @Mapping(target = "longitude", expression = "java(geoPoint.getLon())")
    GeoPointDto toGeoPointDto(GeoPoint geoPoint);
}
