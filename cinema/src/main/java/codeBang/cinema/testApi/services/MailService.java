package codeBang.cinema.testApi.services;

import org.apache.pdfbox.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MailService {

    private JavaMailSender javaMailSender;
    private static final String from = "cinemacodebang@gmail.com";
    private static final String subject = "Reservation CinemaCodeBang";
    private static final String text = "Thank you for your reservation!";

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String to, ByteArrayInputStream inputStream) throws IOException, MessagingException {

            MimeMessage message = javaMailSender.createMimeMessage();
            byte[] data = IOUtils.toByteArray(inputStream);
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            helper.addAttachment("Reservation.pdf",new ByteArrayResource(data));
            javaMailSender.send(message);
    }

    public static boolean isMailValid(String mail){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

}
