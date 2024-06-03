package fiap.codecraft.DTO.request;

public record UserAddressCreateDTORequest(
        String cep,
        int houseNumber,
        String neighborhood,
        String city,
        String state
) {
}
