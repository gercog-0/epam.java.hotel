package by.epam.project.model.dao;

public class SqlQuery {
    /**
     *  QUERY TO TABLE WITH USERS
     */
    public static final String FIND_ALL_USERS = "SELECT userId, login, email, name, surname, balance, " +
            "phone, is_banned, is_activated, roleId FROM users WHERE roleId = ?";
    public static final String FIND_USER_BY_ID = "SELECT userId, login, email, name, surname, balance, " +
            "phone, is_banned, is_activated, roleId FROM users WHERE userId = ?";
    public static final String FIND_USER_BY_EMAIL = "SELECT userId, login, email, name, surname, balance, " +
            "phone, is_banned, is_activated, roleId FROM users WHERE email = ?";
    public static final String FIND_USER_BY_PHONE = "SELECT userId, login, email, name, surname, balance, " +
            "phone, is_banned, is_activated, roleId FROM users WHERE phone = ?";
    public static final String ACTIVATE_USER = "UPDATE users SET is_activated = true WHERE login = ?";
    public static final String BAN_USER = "UPDATE users SET is_banned = true WHERE login = ?";
    public static final String UN_BANE_USER = "UPDATE users SET is_banned = false WHERE login = ?";
    public static final String ADD_USER = "INSERT INTO users (login,email,name,surname,phone,balance," +
            "is_banned,is_activated,roleId) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String FIND_USER_BY_LOGIN = "SELECT userId, login, email, name, surname, " +
            "balance, phone, is_banned, is_activated, roleId FROM users WHERE login = ?";
    public static final String FIND_PASSWORD_BY_LOGIN = "SELECT password FROM users WHERE login = ?";
    public static final String UPDATE_PASSWORD_BY_LOGIN = "UPDATE users SET password = ? WHERE login = ?";
    public static final String UPDATE_BALANCE_BY_LOGIN = "UPDATE users SET balance = ? WHERE login = ?";


    /**
     *  QUERY TO TABLE WITH ROOMS
     */
    public static final String ADD_ROOM = "INSERT into rooms (roomNumber,comfort,price,place_amount, is_active) " +
            "VALUES (?,?,?,?,?)";
    public static final String FIND_ROOM_BY_NUMBER = "SELECT roomId, roomNumber, comfort, price, place_amount, " +
            "is_active FROM rooms WHERE roomNumber = ?";
    public static final String FIND_ALL_ROOMS = "SELECT roomId, roomNumber, comfort, price, place_amount, " +
            "is_active FROM rooms";
    public static final String FIND_ROOMS_BY_COMFORT = "SELECT roomId, roomNumber, comfort, price, place_amount, " +
            "is_active WHERE comfort = ?";
    public static final String FIND_ROOMS_BY_PRICE = "SELECT roomId, roomNumber, comfort, price, place_amount, " +
            "is_active WHERE price = ?";
    public static final String FIND_ROOMS_BY_PLACE_AMOUNT = "SELECT roomId, roomNumber, comfort, price, place_amount, " +
            "is_active WHERE place_amount = ?";
    public static final String FIND_ROOMS_BY_STATUS = "SELECT roomId, roomNumber, comfort, price, place_amount, " +
            "is_active WHERE is_active = ?";
    public static final String SET_ACTIVE_ROOM_STATUS = "UPDATE rooms SET is_active = true WHERE roomNumber = ?";
    public static final String SET_INACTIVE_ROOM_STATUS = "UPDATE rooms SET is_active = false WHERE roomNumber = ?";
    public static final String FIND_FREE_ROOMS = "SELECT roomId, roomNumber, comfort, price, place_amount, is_active " +
            "FROM web_hotel.rooms WHERE comfort = ? AND place_amount >= ? AND is_active = true AND NOT EXISTS (SELECT bookingId, " +
            "arrival_date, departure_date, booking_status, userId_fk, roomId_fk FROM web_hotel.bookings WHERE booking_status != " +
            "'rejected' AND roomId = roomId_fk AND ((? BETWEEN arrival_date AND departure_date) OR (? BETWEEN arrival_date AND departure_date)))";

    /**
     *  QUERY TO TABLE WITH BOOKINGS
     */
    public static final String ADD_BOOKING = "INSERT INTO bookings (arrival_date, departure_date, booking_status, " +
            "userId_fk, roomId_fk, total_price) VALUES(?,?,?,?,?,?)";
    public static final String FIND_ALL_BOOKINGS = "SELECT users.userId, users.login, users.email, users.name, users.surname, " +
            "users.balance, users.phone, users.is_banned, users.is_activated, users.roleId, rooms.roomId, rooms.roomNumber, " +
            "rooms.comfort, rooms.price, rooms.place_amount, rooms.is_active, bookings.bookingId, bookings.arrival_date, " +
            "bookings.departure_date, bookings.booking_status, bookings.total_price FROM web_hotel.bookings JOIN web_hotel.users " +
            "ON users.userId = bookings.userId_fk JOIN web_hotel.rooms ON rooms.roomId = bookings.roomId_fk";
    public static final String FIND_BOOKING_BY_ID = "SELECT users.userId, users.login, users.email, users.name, users.surname, " +
            "users.balance, users.phone, users.is_banned, users.is_activated, users.roleId, rooms.roomId, rooms.roomNumber, " +
            "rooms.comfort, rooms.price, rooms.place_amount, rooms.is_active, bookings.bookingId, bookings.arrival_date, " +
            "bookings.departure_date, bookings.booking_status, bookings.total_price FROM web_hotel.bookings JOIN web_hotel.users " +
            "ON users.userId = bookings.userId_fk JOIN web_hotel.rooms ON rooms.roomId = bookings.roomId_fk WHERE bookings.bookingId = ?";
    public static final String UPDATE_STATUS_BOOKING = "UPDATE bookings SET booking_status = ? WHERE bookingId = ?";
    public static final String FIND_ALL_BOOKINGS_BY_USER_ID = "SELECT users.userId, users.login, users.email, users.name, users.surname, " +
            "users.balance, users.phone, users.is_banned, users.is_activated, users.roleId, rooms.roomId, rooms.roomNumber, " +
            "rooms.comfort, rooms.price, rooms.place_amount, rooms.is_active, bookings.bookingId, bookings.arrival_date, " +
            "bookings.departure_date, bookings.booking_status, bookings.total_price FROM web_hotel.bookings JOIN web_hotel.users " +
            "ON users.userId = bookings.userId_fk JOIN web_hotel.rooms ON rooms.roomId = bookings.roomId_fk WHERE bookings.userId_fk = ?";
    public static final String FIND_ALL_BOOKINGS_BY_STATUS = "SELECT users.userId, users.login, users.email, users.name, users.surname, " +
            "users.balance, users.phone, users.is_banned, users.is_activated, users.roleId, rooms.roomId, rooms.roomNumber, " +
            "rooms.comfort, rooms.price, rooms.place_amount, rooms.is_active, bookings.bookingId, bookings.arrival_date, " +
            "bookings.departure_date, bookings.booking_status, bookings.total_price FROM web_hotel.bookings JOIN web_hotel.users " +
            "ON users.userId = bookings.userId_fk JOIN web_hotel.rooms ON rooms.roomId = bookings.roomId_fk WHERE bookings.booking_status = ?";

    private SqlQuery() {
    }
}
