package by.epam.project.controller.command.impl;

import by.epam.project.controller.Router;
import by.epam.project.controller.command.Command;
import by.epam.project.controller.command.MessageAttribute;
import by.epam.project.controller.command.PagePath;
import by.epam.project.controller.command.PropertiesMessageKey;
import by.epam.project.entity.User;
import by.epam.project.exception.ServiceException;
import by.epam.project.model.service.impl.UserServiceImpl;
import by.epam.project.validator.impl.PaymentCardValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static by.epam.project.util.RequestParameterName.*;


public class MakeDepositCommand implements Command {
    private final UserServiceImpl service = UserServiceImpl.getInstance();
    private final PaymentCardValidatorImpl validator = PaymentCardValidatorImpl.getInstance();

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        HttpSession session = request.getSession();

        try {
            String numberCard = request.getParameter(NUMBER_CARD);
            String dateCard = request.getParameter(DATE_CARD);
            String cvCodeCard = request.getParameter(CV_CODE_CARD);
            String transferAmountString = request.getParameter(TRANSFER_AMOUNT_CARD);
            Map<String, String> checkedData = validator.validateParameters(numberCard,
                    dateCard, cvCodeCard, transferAmountString);

            if (validator.defineIncorrectValues(checkedData)) {
                String loginUser = ((User) (session.getAttribute(MessageAttribute.USER))).getLogin();
                double transferAmountValue = Double.parseDouble(transferAmountString);
                service.depositMoney(loginUser, transferAmountValue);
                request.setAttribute(MessageAttribute.PAYMENT_MESSAGE,
                        PropertiesMessageKey.SUCCESSFULLY_DEPOSIT);
                // TODO: 10.10.2020 redirect maybe + message about operation
                router = new Router(PagePath.HOME);
            } else {
                request.setAttribute(MessageAttribute.PAYMENT_CARD_DATA, checkedData);
                router = new Router(PagePath.PAYMENT_CARD);
            }
        } catch (ServiceException exp) {
            LOGGER.error(exp);
            router = new Router(PagePath.ERROR_500);
        }
        return router;
    }
}
