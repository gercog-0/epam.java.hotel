package by.epam.project.model.service;

import by.epam.project.model.entity.User;
import by.epam.project.util.MailSender;


/**
 * The type Email message service.
 */
public class EmailMessageService {
    private static final EmailMessageService instance =
            new EmailMessageService();

    private EmailMessageService() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static EmailMessageService getInstance() {
        return instance;
    }

    /**
     * Make and send activation email.
     *
     * @param user    the user
     * @param subject the subject
     * @param body    the body
     * @param link    the link
     */
    public void makeAndSendActivationEmail(User user, String subject,
                                           String body, String link) {
        MailSender sender = new MailSender();
        String bodyEmail = String.format(body, user.getName(), link + user.getLogin());
        sender.sendMessage(subject, bodyEmail, user.getEmail());
    }

}
