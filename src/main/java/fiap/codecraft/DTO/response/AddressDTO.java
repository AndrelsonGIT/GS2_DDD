package fiap.codecraft.DTO.response;

public record AddressDTO(
        String cep,
        String street,
        String neighborhood,
        String city,
        String state
) {
}
