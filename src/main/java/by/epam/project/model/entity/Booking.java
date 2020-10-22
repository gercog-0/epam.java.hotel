package by.epam.project.model.entity;

import by.epam.project.util.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * The type Booking.
 */
public class Booking extends Entity {
    /**
     * The enum Status.
     */
    public enum Status {
        /**
         * Waiting status.
         */
        WAITING("waiting"),
        /**
         * Payment status.
         */
        PAYMENT("payment"),
        /**
         * Active status.
         */
        ACTIVE("active"),
        /**
         * Rejected status.
         */
        REJECTED("rejected");

        private final String nameStatus;

        Status(String nameStatus) {
            this.nameStatus = nameStatus;
        }

        /**
         * Gets name status.
         *
         * @return the name status
         */
        public String getNameStatus() {
            return nameStatus;
        }

        /**
         * Gets status by value.
         *
         * @param value the value
         * @return the status by value
         */
        public static Optional<Booking.Status> getStatusByValue(String value) {
            return Arrays.stream(Booking.Status.values()).
                    filter(o -> o.getNameStatus().equals(value)).findAny();
        }
    }

    private int bookingId;
    private User user;
    private Room room;
    private Date arrivalDate;
    private Date departureDate;
    private Status status;
    private double totalPrice;

    /**
     * Instantiates a new Booking.
     *
     * @param bookingId     the booking id
     * @param user          the user
     * @param room          the room
     * @param arrivalDate   the arrival date
     * @param departureDate the departure date
     * @param status        the status
     * @param totalPrice    the total price
     */
    public Booking(int bookingId, User user, Room room, Date arrivalDate, Date departureDate, Status status, double totalPrice) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    /**
     * Instantiates a new Booking.
     *
     * @param user          the user
     * @param room          the room
     * @param arrivalDate   the arrival date
     * @param departureDate the departure date
     * @param status        the status
     * @param totalPrice    the total price
     */
    public Booking(User user, Room room, Date arrivalDate, Date departureDate, Status status, double totalPrice) {
        this.user = user;
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    /**
     * Gets booking id.
     *
     * @return the booking id
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Sets booking id.
     *
     * @param bookingId the booking id
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets arrival date.
     *
     * @return the arrival date
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Get arrival date string string.
     *
     * @return the string
     */
    public String getArrivalDateString(){
        String dateString = DateUtil.parseDateToStringFormat(this.arrivalDate);
        return dateString;
    }

    /**
     * Sets arrival date.
     *
     * @param arrivalDate the arrival date
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * Gets departure date.
     *
     * @return the departure date
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * Get departure date string string.
     *
     * @return the string
     */
    public String getDepartureDateString(){
        String dateString = DateUtil.parseDateToStringFormat(this.departureDate);
        return dateString;
    }

    /**
     * Sets departure date.
     *
     * @param departureDate the departure date
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets total price.
     *
     * @param totalPrice the total price
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Booking booking = (Booking) o;

        if (bookingId != booking.bookingId) {
            return false;
        }
        if (Double.compare(booking.totalPrice, totalPrice) != 0) {
            return false;
        }
        if (user != null ? !user.equals(booking.user) : booking.user != null) {
            return false;
        }
        if (room != null ? !room.equals(booking.room) : booking.room != null) {
            return false;
        }
        if (arrivalDate != null ? !arrivalDate.equals(booking.arrivalDate) : booking.arrivalDate != null) {
            return false;
        }
        if (departureDate != null ? !departureDate.equals(booking.departureDate) : booking.departureDate != null) {
            return false;
        }
        return status == booking.status;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = bookingId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Booking{");
        sb.append("bookingId=").append(bookingId);
        sb.append(", user=").append(user);
        sb.append(", room=").append(room);
        sb.append(", arrivalDate=").append(arrivalDate);
        sb.append(", departureDate=").append(departureDate);
        sb.append(", status=").append(status);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append('}');
        return sb.toString();
    }
}
