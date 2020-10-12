package by.epam.project.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailSender {
    private String username;
    private String password;
    private final Properties properties;

    private static final String MAIL_PROPERTIES = "mail/mail.properties";
    private static final String USER_NAME_PROPERTIES = "mail.user.name";
    private static final String USER_PASSWORD_PROPERTIES = "mail.user.password";
    private static final Logger logger = LogManager.getLogger();

    public MailSender() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(MAIL_PROPERTIES));
        } catch (IOException exp) {
            logger.error("Error uploading a file", exp);
        }
    }

    public void sendMessage(String subject, String body, String email) {
        username = properties.getProperty(USER_NAME_PROPERTIES);
        password = properties.getProperty(USER_PASSWORD_PROPERTIES);
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException exp) {
            logger.error("Error sending a message", exp);
        }
    }
}
