package com.group.requests.msvc_artifact_requests.services.mapper;

import com.group.requests.msvc_artifact_requests.models.dtos.RequestDto;
import com.group.requests.msvc_artifact_requests.models.entities.Request;
import org.mapstruct.*;
import org.springframework.http.RequestEntity;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RequestMapper {

    RequestDto toDTO(Request entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    Request toEntity(RequestDto dto);

    List<RequestDto> toDTOList(List<Request> entities);

    List<Request> toEntityList(List<RequestDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    void updateEntityFromDTO(RequestDto dto, @MappingTarget Request entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    void partialUpdateEntityFromDTO(RequestDto dto, @MappingTarget Request entity);
}
