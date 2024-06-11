package biz.starhotel.platform.star_hotel_platform.Sell.infrastructure.persistence.jpa.repositories;

import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.aggregates.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    boolean existsByGuestNameAndRoomId(String guestName, Integer roomId);
    boolean existsByGuestDniAndRoomId(String guestDni, Integer roomId);
}
