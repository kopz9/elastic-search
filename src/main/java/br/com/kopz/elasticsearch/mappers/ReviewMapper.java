package br.com.kopz.elasticsearch.mappers;

import br.com.kopz.elasticsearch.domain.ReviewCreateUpdateRequest;
import br.com.kopz.elasticsearch.domain.dtos.ReviewCreateUpdateRequestDto;
import br.com.kopz.elasticsearch.domain.dtos.ReviewDto;
import br.com.kopz.elasticsearch.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

  ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateRequestDto reviewCreateUpdateRequestDto);

  ReviewDto toDto(Review review);

}
