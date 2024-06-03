package fiap.codecraft.DTO.response;

public record AuthenticationResponse(
        String userEmail,
        String token
) {
}
