package biz.starhotel.platform.star_hotel_platform.Sell.application.internal.queryservices;

import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.aggregates.Reservation;
import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.queries.GetReservationById;
import biz.starhotel.platform.star_hotel_platform.Sell.domain.services.ReservationQueryService;
import biz.starhotel.platform.star_hotel_platform.Sell.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {

    private final ReservationRepository reservationRepository;

    public ReservationQueryServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Optional<Reservation> handle(GetReservationById query) {
        return reservationRepository.findById(query.reservationId());
    }
}
