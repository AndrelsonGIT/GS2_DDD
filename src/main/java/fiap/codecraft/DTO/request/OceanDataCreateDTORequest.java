package fiap.codecraft.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record OceanDataCreateDTORequest(
    @NotBlank
    String oceanType,
    @NotBlank
    LocalDateTime recordDate,
    @NotNull
    double waterTemperature,
    @NotNull
    double waterPollutionLevel,
    @NotNull
    List<OceanObjectCreateDTORequest> oceanObjects


) {


}
