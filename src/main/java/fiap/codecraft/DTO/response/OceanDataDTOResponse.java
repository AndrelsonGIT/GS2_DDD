package fiap.codecraft.DTO.response;

import fiap.codecraft.model.OceanDataEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record OceanDataDTOResponse(
        Integer id,
        String oceanType,
        LocalDateTime recordDate,
        double waterTemperature,
        double waterPollutionLevel,
        List<OceanObjectDTOResponse> oceanObjects
){

    public OceanDataDTOResponse(OceanDataEntity oceanDataEntity) {
        this(
                oceanDataEntity.getId(),
                oceanDataEntity.getOceanType(),
                oceanDataEntity.getRecordDate(),
                oceanDataEntity.getWaterTemperature(),
                oceanDataEntity.getWaterPollutionLevel(),
                oceanDataEntity.getOceanObjects()
                        .stream()
                        .map(e -> new OceanObjectDTOResponse(
                                e.getId(),
                                e.getObjectType(),
                                e.getObjectWeight()))
                        .collect(Collectors.toList())
        );
    }
}
