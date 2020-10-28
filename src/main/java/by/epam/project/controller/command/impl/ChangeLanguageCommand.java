package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.project.util.RequestParameterName.*;

/**
 * Change language command.
 * The command is responsible for changing the user interface language.
 */
public class ChangeLanguageCommand implements Command {
    private static final String EN_LANGUAGE = "en";
    private static final String RU_LANGUAGE = "ru";

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router;

        String givenLanguage = request.getParameter(LANGUAGE);
        if (givenLanguage.equals(EN_LANGUAGE) || givenLanguage.equals(RU_LANGUAGE)) {
            session.setAttribute(MessageAttribute.LANGUAGE, givenLanguage);
            String currentPage = (String) session.getAttribute(CURRENT_PAGE);
            router = new Router(currentPage);
        } else {
            router = new Router(PagePath.ERROR_404);
        }
        return router;
    }
}
