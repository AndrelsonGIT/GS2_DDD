package fiap.codecraft.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fiap.codecraft.model.UserEntity;
import fiap.codecraft.service.factory.SmtpFormatEmailFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CreationUserEmailSender implements Observer{

    private APIRequestCaller apiRequestCaller;

    private ObjectMapper objectMapper;

    public CreationUserEmailSender(APIRequestCaller apiRequestCaller, ObjectMapper objectMapper) {
        this.apiRequestCaller = apiRequestCaller;
        this.objectMapper = objectMapper;
    }

    @Override
    public void update(UserEntity user) {
        System.out.println("Cheguei a ser chamado no update");
       sendEmail(user);
    }

    public void sendEmail(UserEntity user){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("api-key", "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");

        SmtpFormatEmail formatEmail = new SmtpFormatEmailFactory().create(user, 2);

        try{
            apiRequestCaller.post(
                    "https://api.brevo.com/v3/smtp/email",
                    headers,
                    objectMapper.writeValueAsString(formatEmail));
        }
        catch(InterruptedException | IOException ex){
            throw new RuntimeException("Fail to send email to: " + user.getEmail());
        }
        System.out.println("Fui chamado e executado com sucesso");
    }
}
