package biz.starhotel.platform.star_hotel_platform.Sell.domain.services;

import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.aggregates.Reservation;
import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.queries.GetReservationById;

import java.util.Optional;

public interface ReservationQueryService {
    Optional<Reservation> handle(GetReservationById query);
}
