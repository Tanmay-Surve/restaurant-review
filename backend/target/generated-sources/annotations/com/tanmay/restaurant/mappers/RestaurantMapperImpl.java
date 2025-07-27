package com.tanmay.restaurant.mappers;

import com.tanmay.restaurant.domain.RestaurantCreateUpdateRequest;
import com.tanmay.restaurant.domain.dtos.AddressDto;
import com.tanmay.restaurant.domain.dtos.GeoPointDto;
import com.tanmay.restaurant.domain.dtos.OperatingHoursDto;
import com.tanmay.restaurant.domain.dtos.PhotoDto;
import com.tanmay.restaurant.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.tanmay.restaurant.domain.dtos.RestaurantDto;
import com.tanmay.restaurant.domain.dtos.RestaurantSummaryDto;
import com.tanmay.restaurant.domain.dtos.ReviewDto;
import com.tanmay.restaurant.domain.dtos.TimeRangeDto;
import com.tanmay.restaurant.domain.dtos.UserDto;
import com.tanmay.restaurant.domain.entities.Address;
import com.tanmay.restaurant.domain.entities.OperatingHours;
import com.tanmay.restaurant.domain.entities.Photo;
import com.tanmay.restaurant.domain.entities.Restaurant;
import com.tanmay.restaurant.domain.entities.Review;
import com.tanmay.restaurant.domain.entities.TimeRange;
import com.tanmay.restaurant.domain.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-27T11:22:09+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        RestaurantCreateUpdateRequest.RestaurantCreateUpdateRequestBuilder restaurantCreateUpdateRequest = RestaurantCreateUpdateRequest.builder();

        restaurantCreateUpdateRequest.name( dto.getName() );
        restaurantCreateUpdateRequest.cuisineType( dto.getCuisineType() );
        restaurantCreateUpdateRequest.contactInformation( dto.getContactInformation() );
        restaurantCreateUpdateRequest.address( addressDtoToAddress( dto.getAddress() ) );
        restaurantCreateUpdateRequest.operatingHours( operatingHoursDtoToOperatingHours( dto.getOperatingHours() ) );
        List<String> list = dto.getPhotoIds();
        if ( list != null ) {
            restaurantCreateUpdateRequest.photoIds( new ArrayList<String>( list ) );
        }

        return restaurantCreateUpdateRequest.build();
    }

    @Override
    public RestaurantDto toRestaurantDto(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantDto.RestaurantDtoBuilder restaurantDto = RestaurantDto.builder();

        restaurantDto.totalReviews( populateTotalReviews( restaurant.getReviews() ) );
        restaurantDto.id( restaurant.getId() );
        restaurantDto.name( restaurant.getName() );
        restaurantDto.cuisineType( restaurant.getCuisineType() );
        restaurantDto.contactInformation( restaurant.getContactInformation() );
        restaurantDto.averageRating( restaurant.getAverageRating() );
        restaurantDto.geoLocation( toGeoPointDto( restaurant.getGeoLocation() ) );
        restaurantDto.address( addressToAddressDto( restaurant.getAddress() ) );
        restaurantDto.operatingHours( operatingHoursToOperatingHoursDto( restaurant.getOperatingHours() ) );
        restaurantDto.photos( photoListToPhotoDtoList( restaurant.getPhotos() ) );
        restaurantDto.reviews( reviewListToReviewDtoList( restaurant.getReviews() ) );
        restaurantDto.createdBy( userToUserDto( restaurant.getCreatedBy() ) );

        return restaurantDto.build();
    }

    @Override
    public RestaurantSummaryDto toSummaryDto(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantSummaryDto.RestaurantSummaryDtoBuilder restaurantSummaryDto = RestaurantSummaryDto.builder();

        restaurantSummaryDto.totalReviews( populateTotalReviews( restaurant.getReviews() ) );
        restaurantSummaryDto.id( restaurant.getId() );
        restaurantSummaryDto.name( restaurant.getName() );
        restaurantSummaryDto.cuisineType( restaurant.getCuisineType() );
        restaurantSummaryDto.averageRating( restaurant.getAverageRating() );
        restaurantSummaryDto.address( addressToAddressDto( restaurant.getAddress() ) );
        restaurantSummaryDto.photos( photoListToPhotoDtoList( restaurant.getPhotos() ) );

        return restaurantSummaryDto.build();
    }

    @Override
    public GeoPointDto toGeoPointDto(GeoPoint geoPoint) {
        if ( geoPoint == null ) {
            return null;
        }

        GeoPointDto.GeoPointDtoBuilder geoPointDto = GeoPointDto.builder();

        geoPointDto.latitude( geoPoint.getLat() );
        geoPointDto.longitude( geoPoint.getLon() );

        return geoPointDto.build();
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.streetNumber( addressDto.getStreetNumber() );
        address.streetName( addressDto.getStreetName() );
        address.unit( addressDto.getUnit() );
        address.city( addressDto.getCity() );
        address.state( addressDto.getState() );
        address.postalCode( addressDto.getPostalCode() );
        address.country( addressDto.getCountry() );

        return address.build();
    }

    protected TimeRange timeRangeDtoToTimeRange(TimeRangeDto timeRangeDto) {
        if ( timeRangeDto == null ) {
            return null;
        }

        TimeRange.TimeRangeBuilder timeRange = TimeRange.builder();

        timeRange.openTime( timeRangeDto.getOpenTime() );
        timeRange.closeTime( timeRangeDto.getCloseTime() );

        return timeRange.build();
    }

    protected OperatingHours operatingHoursDtoToOperatingHours(OperatingHoursDto operatingHoursDto) {
        if ( operatingHoursDto == null ) {
            return null;
        }

        OperatingHours.OperatingHoursBuilder operatingHours = OperatingHours.builder();

        operatingHours.monday( timeRangeDtoToTimeRange( operatingHoursDto.getMonday() ) );
        operatingHours.tuesday( timeRangeDtoToTimeRange( operatingHoursDto.getTuesday() ) );
        operatingHours.wednesday( timeRangeDtoToTimeRange( operatingHoursDto.getWednesday() ) );
        operatingHours.thursday( timeRangeDtoToTimeRange( operatingHoursDto.getThursday() ) );
        operatingHours.friday( timeRangeDtoToTimeRange( operatingHoursDto.getFriday() ) );
        operatingHours.saturday( timeRangeDtoToTimeRange( operatingHoursDto.getSaturday() ) );
        operatingHours.sunday( timeRangeDtoToTimeRange( operatingHoursDto.getSunday() ) );

        return operatingHours.build();
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto.AddressDtoBuilder addressDto = AddressDto.builder();

        addressDto.streetNumber( address.getStreetNumber() );
        addressDto.streetName( address.getStreetName() );
        addressDto.unit( address.getUnit() );
        addressDto.city( address.getCity() );
        addressDto.state( address.getState() );
        addressDto.postalCode( address.getPostalCode() );
        addressDto.country( address.getCountry() );

        return addressDto.build();
    }

    protected TimeRangeDto timeRangeToTimeRangeDto(TimeRange timeRange) {
        if ( timeRange == null ) {
            return null;
        }

        TimeRangeDto.TimeRangeDtoBuilder timeRangeDto = TimeRangeDto.builder();

        timeRangeDto.openTime( timeRange.getOpenTime() );
        timeRangeDto.closeTime( timeRange.getCloseTime() );

        return timeRangeDto.build();
    }

    protected OperatingHoursDto operatingHoursToOperatingHoursDto(OperatingHours operatingHours) {
        if ( operatingHours == null ) {
            return null;
        }

        OperatingHoursDto.OperatingHoursDtoBuilder operatingHoursDto = OperatingHoursDto.builder();

        operatingHoursDto.monday( timeRangeToTimeRangeDto( operatingHours.getMonday() ) );
        operatingHoursDto.tuesday( timeRangeToTimeRangeDto( operatingHours.getTuesday() ) );
        operatingHoursDto.wednesday( timeRangeToTimeRangeDto( operatingHours.getWednesday() ) );
        operatingHoursDto.thursday( timeRangeToTimeRangeDto( operatingHours.getThursday() ) );
        operatingHoursDto.friday( timeRangeToTimeRangeDto( operatingHours.getFriday() ) );
        operatingHoursDto.saturday( timeRangeToTimeRangeDto( operatingHours.getSaturday() ) );
        operatingHoursDto.sunday( timeRangeToTimeRangeDto( operatingHours.getSunday() ) );

        return operatingHoursDto.build();
    }

    protected PhotoDto photoToPhotoDto(Photo photo) {
        if ( photo == null ) {
            return null;
        }

        PhotoDto.PhotoDtoBuilder photoDto = PhotoDto.builder();

        photoDto.url( photo.getUrl() );
        photoDto.uploadDate( photo.getUploadDate() );

        return photoDto.build();
    }

    protected List<PhotoDto> photoListToPhotoDtoList(List<Photo> list) {
        if ( list == null ) {
            return null;
        }

        List<PhotoDto> list1 = new ArrayList<PhotoDto>( list.size() );
        for ( Photo photo : list ) {
            list1.add( photoToPhotoDto( photo ) );
        }

        return list1;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.username( user.getUsername() );
        userDto.givenName( user.getGivenName() );
        userDto.familyName( user.getFamilyName() );

        return userDto.build();
    }

    protected ReviewDto reviewToReviewDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewDto.ReviewDtoBuilder reviewDto = ReviewDto.builder();

        reviewDto.id( review.getId() );
        reviewDto.content( review.getContent() );
        reviewDto.rating( review.getRating() );
        reviewDto.datePosted( review.getDatePosted() );
        reviewDto.lastEdited( review.getLastEdited() );
        reviewDto.photos( photoListToPhotoDtoList( review.getPhotos() ) );
        reviewDto.writtenBy( userToUserDto( review.getWrittenBy() ) );

        return reviewDto.build();
    }

    protected List<ReviewDto> reviewListToReviewDtoList(List<Review> list) {
        if ( list == null ) {
            return null;
        }

        List<ReviewDto> list1 = new ArrayList<ReviewDto>( list.size() );
        for ( Review review : list ) {
            list1.add( reviewToReviewDto( review ) );
        }

        return list1;
    }
}
