package biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.resources;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateReservationResource(String guestDni, String guestName, String guestEmail, Integer roomId, String roomName, String roomType, LocalDate startDate, LocalDate endDate, BigDecimal price, BigDecimal discountPercent) {
}
