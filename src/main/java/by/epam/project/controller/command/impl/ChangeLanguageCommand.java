package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.project.util.RequestParameterName.*;

public class ChangeLanguageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String givenLanguage = request.getParameter(LANGUAGE);
        session.setAttribute(MessageAttribute.LANGUAGE, givenLanguage);
        String currentPage = (String) session.getAttribute(CURRENT_PAGE);

        return new Router(currentPage);
    }
}
