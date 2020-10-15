package by.epam.project.controller.command;

import by.epam.project.controller.command.impl.*;
import by.epam.project.controller.command.impl.page.*;

public enum CommandType {
    SIGN_IN(new SignInCommand(), "sign_in"),
    SIGN_UP(new SignUpCommand(), "sign_up"),
    PASSING_HOME(new PassingToHomeCommand(), "passing_home"),
    PASSING_SIGN_IN(new PassingToSignInCommand(), "passing_sign_in"),
    PASSING_SIGN_UP(new PassingToSignUpCommand(), "passing_sign_up"),
    PASSING_ACTIVATION(new PassingToActivationCommand(), "passing_activation"),
    PASSING_FILTER_ROOMS(new PassingToFilterRoomsCommand(), "passing_filter_rooms"),
    PASSING_PAYMENT_CARD(new PassingToPaymentCardCommand(), "passing_payment_card"),
    PASSING_USER_PROFILE(new PassingToUserProfileCommand(), "passing_user_profile"),
    PASSING_ACTIVE_BOOKING_ADMIN(new PassingToActiveBookingAdminCommand(), "passing_active_booking_admin"),
    PASSING_ROOMS_ADMIN(new PassingToRoomsAdminCommand(), "passing_rooms_admin"),
    PASSING_USERS_ADMIN(new PassingToUsersAdminCommand(), "passing_users_admin"),
    CHANGE_LANGUAGE(new ChangeLanguageCommand(), "change_language"),
    BOOKING(new BookingCommand(), "booking"),
    FILTER_ROOMS(new FilterRoomsCommand(), "filter_rooms"),
    SORT_ROOMS(new SortRoomsCommand(), "sort_rooms"),
    CONFIRM_SIGN_UP(new ConfirmSignUpCommand(), "confirm_sign_up"),
    MAKE_DEPOSIT(new MakeDepositCommand(), "make_deposit"),
    BAN_USER(new BanUserCommand(), "ban_user"),
    UN_BAN_USER(new UnBanUserCommand(), "un_ban"),
    LOG_OUT(new LogOutCommand(), "log_out");

    private final Command command;
    private final String nameCommand;

    CommandType(Command command, String nameCommand) {
        this.command = command;
        this.nameCommand = nameCommand;
    }

    public Command getCommand() {
        return command;
    }

    public String getNameCommand() {
        return nameCommand;
    }
}
