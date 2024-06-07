package fiap.codecraft.service;

import java.util.List;

public record SmtpFormatEmail (
        List<EmailNameFormat> to,
        int templateId,
        FormatEmailParams params
){
}
