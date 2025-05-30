package com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.services.mapper;

import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.dtos.DetControlFlotaDto;
import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.entities.DetControlFlota;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDetControlFlotaMapper {
    DetControlFlotaDto toDTO(DetControlFlota entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    DetControlFlota toEntity(DetControlFlotaDto dto);

    List<DetControlFlotaDto> toDTOList(List<DetControlFlota> entities);

    List<DetControlFlota> toEntityList(List<DetControlFlotaDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    void updateEntityFromDTO(DetControlFlotaDto dto, @MappingTarget DetControlFlota entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    void partialUpdateEntityFromDTO(DetControlFlotaDto dto, @MappingTarget DetControlFlota entity);

}
