package com.tanmay.restaurant.mappers;

import com.tanmay.restaurant.domain.dtos.PhotoDto;
import com.tanmay.restaurant.domain.entities.Photo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-27T11:22:09+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class PhotoMapperImpl implements PhotoMapper {

    @Override
    public PhotoDto toDto(Photo photo) {
        if ( photo == null ) {
            return null;
        }

        PhotoDto.PhotoDtoBuilder photoDto = PhotoDto.builder();

        photoDto.url( photo.getUrl() );
        photoDto.uploadDate( photo.getUploadDate() );

        return photoDto.build();
    }
}
