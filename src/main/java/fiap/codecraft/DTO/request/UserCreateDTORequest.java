package fiap.codecraft.DTO.request;

public record UserCreateDTORequest(
        String fullName,

        String email,

        String password,

        int houseNumber,

        String cep
) {

}
