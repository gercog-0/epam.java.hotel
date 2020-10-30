package by.epam.project.controller.command;

import java.util.EnumSet;
import java.util.Set;

import static by.epam.project.controller.command.CommandName.*;

/**
 * The enum Command type.
 */
public enum RolePermission {
    /**
     * Guest command type.
     */
    GUEST(EnumSet.of(
            PASSING_HOME,
            CONFIRM_SIGN_UP,
            CHANGE_LANGUAGE,
            SIGN_IN,
            SIGN_UP,
            PASSING_SIGN_IN,
            PASSING_SIGN_UP
    )),
    /**
     * User command type.
     */
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
    /**
     * Administrator command type.
     */
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

    RolePermission(Set<CommandName> commandNames) {
        this.commandNames = commandNames;
    }

    /**
     * Gets command names.
     *
     * @return the command names
     */
    public Set<CommandName> getCommandNames() {
        return commandNames;
    }
}
