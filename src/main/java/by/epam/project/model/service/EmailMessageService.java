package by.epam.project.model.service;

import by.epam.project.entity.User;
import by.epam.project.util.MailSender;

import java.util.Locale;
import java.util.ResourceBundle;

public class EmailMessageService {
    private static final EmailMessageService instance =
            new EmailMessageService();

    private EmailMessageService() {
    }

    public static EmailMessageService getInstance() {
        return instance;
    }

    public void makeAndSendActivationEmail(User user, String subject,
                                           String body, String link) {
        MailSender sender = new MailSender();
        String bodyEmail = String.format(body, user.getName(), link + user.getLogin());
        sender.sendMessage(subject, bodyEmail, user.getEmail());
    }

}
