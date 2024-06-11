package biz.starhotel.platform.star_hotel_platform.Sell.domain.exceptions;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Integer id) {
        super("Reservation with id " + id + " not found");
    }
}
