package devrep.project.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.util.Map;
import java.util.Properties;

public class SendMailUtils {

    private JavaMailSenderImpl mailSender;

    public void setInitData(String username,String passwd){

        mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(username);
        mailSender.setPassword(passwd);
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.timeout", 5000);
        javaMailProperties.put("mail.debug", "true");
        mailSender.setJavaMailProperties(javaMailProperties);
    }

    public void simpleMailSend(String email,String subject,String text) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(mailSender.getUsername());
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }


    public void attachedSend(String email,String subject,String text,Map<String,String> paths) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(mailSender.getUsername());
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(text);

        if (paths!=null){
            paths.forEach((k,v)->{
                 FileSystemResource file = new FileSystemResource(v);
                 try {
                     helper.addAttachment(k, file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        mailSender.send(message);
    }

}
