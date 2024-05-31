package fiap.codecraft.DTO.response;

import fiap.codecraft.model.OceanData;

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

    public OceanDataDTOResponse(OceanData oceanData) {
        this(
                oceanData.getId(),
                oceanData.getOceanType(),
                oceanData.getRecordDate(),
                oceanData.getWaterTemperature(),
                oceanData.getWaterPollutionLevel(),
                oceanData.getOceanObjects()
                        .stream()
                        .map(e -> new OceanObjectDTOResponse(
                                e.getId(),
                                e.getObjectType(),
                                e.getObjectWeight()))
                        .collect(Collectors.toList())
        );
    }
}
