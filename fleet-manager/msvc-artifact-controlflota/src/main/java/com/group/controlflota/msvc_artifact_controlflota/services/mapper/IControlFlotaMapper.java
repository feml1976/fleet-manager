package com.group.controlflota.msvc_artifact_controlflota.services.mapper;

import java.util.List;

import com.group.controlflota.msvc_artifact_controlflota.models.dtos.ControlFlotaDto;
import com.group.controlflota.msvc_artifact_controlflota.models.entities.ControlFlota;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IControlFlotaMapper {
    ControlFlotaDto toDTO(ControlFlota entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    ControlFlota toEntity(ControlFlotaDto dto);

    List<ControlFlotaDto> toDTOList(List<ControlFlota> entities);

    List<ControlFlota> toEntityList(List<ControlFlotaDto> dtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    void updateEntityFromDTO(ControlFlotaDto dto, @MappingTarget ControlFlota entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    void partialUpdateEntityFromDTO(ControlFlotaDto dto, @MappingTarget ControlFlota entity);
}
