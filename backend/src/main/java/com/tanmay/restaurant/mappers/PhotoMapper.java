package com.tanmay.restaurant.mappers;

import com.tanmay.restaurant.domain.dtos.PhotoDto;
import com.tanmay.restaurant.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {

    PhotoDto toDto(Photo photo);

}
