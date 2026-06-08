package br.com.kopz.elasticsearch.mappers;

import br.com.kopz.elasticsearch.domain.dtos.PhotoDto;
import br.com.kopz.elasticsearch.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {

  PhotoDto toDto(Photo photo);

}
