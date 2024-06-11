package biz.starhotel.platform.star_hotel_platform.Sell.application.internal.commandservices;

import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.aggregates.Reservation;
import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.commands.CreateReservationCommand;
import biz.starhotel.platform.star_hotel_platform.Sell.domain.services.ReservationCommandService;
import biz.starhotel.platform.star_hotel_platform.Sell.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {

    private final ReservationRepository reservationRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Integer handle(CreateReservationCommand command) {
        if (reservationRepository.existsByGuestNameAndRoomId(command.guestName(), command.roomId()))
            throw new IllegalArgumentException("Reservation already exists for guest name: " + command.guestName() + " and room id: " + command.roomId());

        if (reservationRepository.existsByGuestDniAndRoomId(command.guestDni(), command.roomId()))
            throw new IllegalArgumentException("Reservation already exists for guest dni: " + command.guestDni() + " and room id: " + command.roomId());

        var reservation = new Reservation(command);
        try {
            reservationRepository.save(reservation);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving reservation: " + e.getMessage());
        }
        return reservation.getId();
    }
}
