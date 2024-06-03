package fiap.codecraft.DTO.response;

public record UserCreateDTOResponse(
        int id,
        String fullName,
        String email,
        String password,
        AddressDTO address
) {
    public UserCreateDTOResponse(int id, String fullName, String email, String password, String cep,
                                 String street, String neighborhood, String city, String state) {
        this(id, fullName, email, password, new AddressDTO(cep, street, neighborhood, city, state));
    }
}
