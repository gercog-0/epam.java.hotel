package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class PaymentCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        return null;
    }
}
