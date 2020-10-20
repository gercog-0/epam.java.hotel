package by.epam.project.controller.command;

import by.epam.project.controller.command.impl.*;
import by.epam.project.controller.command.impl.page.*;

public enum CommandType {
    CONFIRM_SIGN_UP(new ConfirmSignUpCommand(), "confirm_sign_up"),
    MAKE_DEPOSIT(new MakeDepositCommand(), "make_deposit"),
    LOG_OUT(new LogOutCommand(), "log_out"),
    PAYMENT(new PaymentCommand(), "payment"),
    CHANGE_LANGUAGE(new ChangeLanguageCommand(), "change_language"),
    SIGN_IN(new SignInCommand(), "sign_in"),
    SIGN_UP(new SignUpCommand(), "sign_up"),
    PASSING_HOME(new PassingToHomeCommand(), "passing_home"),
    PASSING_SIGN_IN(new PassingToSignInCommand(), "passing_sign_in"),
    PASSING_SIGN_UP(new PassingToSignUpCommand(), "passing_sign_up"),
    PASSING_FILTER_ROOMS(new PassingToFilterRoomsCommand(), "passing_filter_rooms"),
    PASSING_PAYMENT_CARD(new PassingToPaymentCardCommand(), "passing_payment_card"),
    PASSING_USER_PROFILE(new PassingToUserProfileCommand(), "passing_user_profile"),
    PASSING_WAITING_BOOKINGS_ADMIN(new PassingToWaitingBookingsAdminCommand(), "passing_waiting_bookings_admin"),
    PASSING_ROOMS_ADMIN(new PassingToRoomsAdminCommand(), "passing_rooms_admin"),
    PASSING_USERS_ADMIN(new PassingToUsersAdminCommand(), "passing_users_admin"),
    BOOKING(new BookingCommand(), "booking"),
    APPROVE_BOOKING(new ApproveBookingCommand(), "approve_command"),
    REJECTED_BOOKING(new RejectedBookingCommand(), "rejected_booking"),
    SHOW_ALL_BOOKINGS(new ShowAllBookingsCommand(), "show_all_booking"),
    SORT_BOOKINGS(new SortBookingsCommand(), "sort_bookings"),
    DISABLE_ROOM(new DisableRoomCommand(), "disable_room"),
    ACTIVATE_ROOM(new ActivateRoomCommand(), "activate_room"),
    FILTER_ROOMS(new FilterRoomsCommand(), "filter_rooms"),
    SORT_ROOMS(new SortRoomsCommand(), "sort_rooms"),
    ADD_ROOM(new AddRoomCommand(), "add_room"),
    SORT_USERS(new SortUsersCommand(), "sort_users"),
    BAN_USER(new BanUserCommand(), "ban_user"),
    UN_BAN_USER(new UnBanUserCommand(), "un_ban_user");

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
