package by.epam.project.util;

public class RequestParameterName {
    /**
     * These parameters are used for working with request.
     * Also when validating data, as well as in utility classes.
     */
    public static final String USER_ID = "userId";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_PHONE = "phone";
    public static final String USER_BALANCE = "balance";
    public static final String USER_IS_BANNED = "is_banned";
    public static final String USER_IS_ACTIVATED = "is_activated";
    public static final String USER_ROLE_ID = "roleId";
    public static final String USER_TYPE_SORT = "sortType";

    public static final String ROOM_ID = "roomId";
    public static final String ROOM_NUMBER = "roomNumber";
    public static final String ROOM_COMFORT = "comfort";
    public static final String ROOM_PRICE = "price";
    public static final String ROOM_PLACE_AMOUNT = "place_amount";
    public static final String ROOM_IS_ACTIVE = "is_active";
    public static final String ROOM_TYPE_SORT = "type_sort";
    public static final String ROOM_LIST_PAGE = "listPage";
    public static final String PAGINATION_ROOMS = "paginationRooms";

    public static final String BOOKING_ID = "bookingId";
    public static final String BOOKING_ARRIVAL_DATE = "arrival_date";
    public static final String BOOKING_DEPARTURE_DATE = "departure_date";
    public static final String BOOKING_STATUS = "booking_status";
    public static final String BOOKING_USER_ID_FK = "userId_fk";
    public static final String BOOKING_ROOM_ID_FK = "roomId_fk";
    public static final String BOOKING_TOTAL_PRICE = "total_price";
    public static final String BOOKING_TYPE_SORT = "sortType";

    public static final String LOGIN_UNIQUE = "loginUnique";
    public static final String EMAIL_UNIQUE = "emailUnique";
    public static final String PHONE_UNIQUE = "phoneUnique";
    public static final String ROOM_NUMBER_UNIQUE = "numberUnique";
    public static final String NOT_UNIQUE = "notUnique";

    public static final String LANGUAGE = "language";
    public static final String EMAIL_SUBJECT = "emailSubject";
    public static final String EMAIL_BODY = "emailBody";
    public static final String EMAIL_USER = "emailUser";
    public static final String EMAIL_ACTIVATION_LINK = "activationLink";

    public static final String NUMBER_CARD = "numberCard";
    public static final String DATE_CARD = "dateCard";
    public static final String CV_CODE_CARD = "codeCard";
    public static final String TRANSFER_AMOUNT_CARD = "transferAmount";

    public static final String COMFORT_ROOM = "comfort";
    public static final String PLACE_AMOUNT_ROOM = "placeAmount";
    public static final String BOOKING_DATE_FROM = "arrivalDate";
    public static final String BOOKING_DATE_TO = "departureDate";
    public static final String ROOMS = "rooms";

    public static final String COMMAND = "command";
    public static final String CURRENT_PAGE = "currentPage";

    private RequestParameterName() {
    }
}