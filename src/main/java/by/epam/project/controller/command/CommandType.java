package by.epam.project.controller.command;

import by.epam.project.controller.command.impl.*;
import by.epam.project.controller.command.impl.page.*;

public enum CommandType {
    CONFIRM_SIGN_UP(new ConfirmSignUpCommand()),
    MAKE_DEPOSIT(new MakeDepositCommand()),
    LOG_OUT(new LogOutCommand()),
    PAYMENT(new PaymentCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand()),
    SIGN_IN(new SignInCommand()),
    SIGN_UP(new SignUpCommand()),
    PASSING_HOME(new PassingToHomeCommand()),
    PASSING_SIGN_IN(new PassingToSignInCommand()),
    PASSING_SIGN_UP(new PassingToSignUpCommand()),
    PASSING_FILTER_ROOMS(new PassingToFilterRoomsCommand()),
    PASSING_PAYMENT_CARD(new PassingToPaymentCardCommand()),
    PASSING_USER_PROFILE(new PassingToUserProfileCommand()),
    PASSING_WAITING_BOOKINGS_ADMIN(new PassingToWaitingBookingsAdminCommand()),
    PASSING_ROOMS_ADMIN(new PassingToRoomsAdminCommand()),
    PASSING_USERS_ADMIN(new PassingToUsersAdminCommand()),
    BOOKING(new BookingCommand()),
    APPROVE_BOOKING(new ApproveBookingCommand()),
    REJECTED_BOOKING(new RejectedBookingCommand()),
    SHOW_ALL_BOOKINGS(new ShowAllBookingsCommand()),
    SORT_BOOKINGS(new SortBookingsCommand()),
    DISABLE_ROOM(new DisableRoomCommand()),
    ACTIVATE_ROOM(new ActivateRoomCommand()),
    FILTER_ROOMS(new FilterRoomsCommand()),
    SORT_ROOMS(new SortRoomsCommand()),
    ADD_ROOM(new AddRoomCommand()),
    SORT_USERS(new SortUsersCommand()),
    BAN_USER(new BanUserCommand()),
    UN_BAN_USER(new UnBanUserCommand());

    private final Command command;


    CommandType(Command command) {
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }
}
