package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

import static by.epam.project.util.RequestParameter.*;

public class ChangeLanguageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        String page;
        String givenLanguage = request.getParameter(LANGUAGE);
        request.getSession().setAttribute(MessageAttribute.LANGUAGE, givenLanguage);
        return new Router(PagePath.HOME);
    }
}
