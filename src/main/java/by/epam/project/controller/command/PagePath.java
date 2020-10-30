package by.epam.project.controller.command;

/**
 * This class contains paths to JSP pages
 */
public class PagePath {
    public final static String INDEX = "/index.jsp";
    public final static String HOME = "jsp/home.jsp";
    public final static String SIGN_IN = "jsp/signIn.jsp";
    public final static String SIGN_UP = "jsp/signUp.jsp";
    public final static String ERROR_404 = "jsp/error404.jsp";
    public final static String ERROR_500 = "jsp/error500.jsp";
    public final static String NOTIFICATION = "jsp/notification.jsp";
    public final static String BANNED_INFO = "jsp/bannedInfo.jsp";
    public final static String USER_PROFILE = "jsp/userProfile.jsp";
    public final static String BOOKING = "jsp/booking.jsp";
    public final static String PAYMENT_CARD = "jsp/paymentCard.jsp";
    public final static String ROOMS = "jsp/rooms.jsp";
    public final static String WAITING_BOOKING_ADMIN = "jsp/waitingBookingsAdmin.jsp";
    public final static String ROOMS_ADMIN = "jsp/roomsAdmin.jsp";
    public final static String USERS_ADMIN = "jsp/usersAdmin.jsp";


    public static final String EMAIL_ACTIVATION_LINK = "http://localhost:8080/DeluxeHotel?command=confirm_sign_up&login=";

    private PagePath(){}
}
