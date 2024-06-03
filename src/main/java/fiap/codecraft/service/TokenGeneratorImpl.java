package fiap.codecraft.service;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class TokenGeneratorImpl implements TokenGenerator{

    @Override
    public String generateToken(String inputData) {
        SecureRandom secureRandom = new SecureRandom();

        byte[] randomBytes = new byte[64];
        secureRandom.nextBytes(randomBytes);
        String randomString = Base64.encodeBase64URLSafeString(randomBytes);

        String combined = inputData + randomString;

        byte[] hash = DigestUtils.sha512(combined);

        String token = Base64.encodeBase64URLSafeString(hash);

        return token.length() > 255 ? token.substring(0, 255) : token;
    }
}
