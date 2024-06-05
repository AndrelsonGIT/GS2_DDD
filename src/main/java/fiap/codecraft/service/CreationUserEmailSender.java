package fiap.codecraft.service;

import fiap.codecraft.model.UserEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreationUserEmailSender implements Observer{

    private APIRequestCaller apiRequestCaller;

    public CreationUserEmailSender(APIRequestCaller apiRequestCaller) {
        this.apiRequestCaller = apiRequestCaller;
    }

    @Override
    public void update(UserEntity user) {
       sendEmail(user);
    }

    public void sendEmail(UserEntity user){
        try{
            apiRequestCaller.post("https://api.brevo.com/v3/smtp/email",  );
        }
        catch(InterruptedException | IOException ex){
            throw new RuntimeException("Fail to send email to: " + user.getEmail());
        }
    }
}
