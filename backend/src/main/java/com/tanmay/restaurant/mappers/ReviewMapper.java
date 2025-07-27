package com.tanmay.restaurant.mappers;

import com.tanmay.restaurant.domain.ReviewCreateUpdateRequest;
import com.tanmay.restaurant.domain.dtos.ReviewCreateUpdateRequestDto;
import com.tanmay.restaurant.domain.dtos.ReviewDto;
import com.tanmay.restaurant.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateRequestDto dto);

    ReviewDto toDto(Review review);

}
