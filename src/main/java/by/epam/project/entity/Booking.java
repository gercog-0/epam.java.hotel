package by.epam.project.entity;

import java.util.Date;

public class Booking extends Entity {
    public enum Status {
        WAITING("waiting"),
        APPROVED("approved"),
        PAYMENT("payment"),
        ACTIVE("active");

        private final String nameStatus;

        Status(String nameStatus) {
            this.nameStatus = nameStatus;
        }

        public String getNameStatus() {
            return nameStatus;
        }
    }

    private int bookingId;
    private User user;
    private Room room;
    private Date arrivalDate;
    private Date departureDate;
    private Status status;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        int result = bookingId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
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
        sb.append('}');
        return sb.toString();
    }
}
