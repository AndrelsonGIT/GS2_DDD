package fiap.codecraft.service.factory;

import fiap.codecraft.model.UserEntity;
import fiap.codecraft.service.EmailNameFormat;
import fiap.codecraft.service.FormatEmailParams;
import fiap.codecraft.service.SmtpFormatEmail;

import java.util.List;

public class SmtpFormatEmailFactory {

    public SmtpFormatEmail create(UserEntity user, int templateId) {
        EmailNameFormat emailName = new EmailNameFormat(user.getEmail(), user.getFullName());

        String[] nameParts = user.getFullName().split(" ");

        String firstName = nameParts[0];

        String lastName = nameParts.length > 1 ? nameParts[1] : "";

        FormatEmailParams formatEmailParams = new FormatEmailParams(firstName, lastName);

        return new SmtpFormatEmail(List.of(emailName),templateId, formatEmailParams);
    }
}
