package by.epam.project.controller.command;

import java.util.EnumSet;
import java.util.Set;

import static by.epam.project.controller.command.CommandName.*;

public enum CommandType {
    GUEST(EnumSet.of(
            PASSING_HOME,
            CONFIRM_SIGN_UP,
            CHANGE_LANGUAGE,
            SIGN_IN,
            SIGN_UP,
            PASSING_SIGN_IN,
            PASSING_SIGN_UP
    )),
    USER(EnumSet.of(
            PASSING_HOME,
            MAKE_DEPOSIT,
            LOG_OUT,
            PAYMENT,
            CHANGE_LANGUAGE,
            PASSING_FILTER_ROOMS,
            PASSING_PAYMENT_CARD,
            PASSING_USER_PROFILE,
            BOOKING,
            FILTER_ROOMS,
            SORT_ROOMS,
            SORT_BOOKINGS
    )),
    ADMINISTRATOR(EnumSet.of(
            PASSING_HOME,
            LOG_OUT,
            CHANGE_LANGUAGE,
            PASSING_WAITING_BOOKINGS_ADMIN,
            PASSING_ROOMS_ADMIN,
            PASSING_USERS_ADMIN,
            APPROVE_BOOKING,
            REJECTED_BOOKING,
            SHOW_ALL_BOOKINGS,
            SORT_BOOKINGS,
            DISABLE_ROOM,
            ACTIVATE_ROOM,
            SORT_ROOMS,
            ADD_ROOM,
            SORT_USERS,
            BAN_USER,
            UN_BAN_USER
    ));

    private final Set<CommandName> commandNames;

    CommandType(Set<CommandName> commandNames) {
        this.commandNames = commandNames;
    }

    public Set<CommandName> getCommandNames() {
        return commandNames;
    }
}
