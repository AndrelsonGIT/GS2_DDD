package fiap.codecraft.DTO.request;

import jakarta.validation.constraints.NotBlank;

public record UserEditEmailDTORequest(
    @NotBlank
    String newPassword
) {
}
