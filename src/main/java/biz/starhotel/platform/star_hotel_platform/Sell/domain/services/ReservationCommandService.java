package biz.starhotel.platform.star_hotel_platform.Sell.domain.services;

import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.commands.CreateReservationCommand;

public interface ReservationCommandService {
    Integer handle(CreateReservationCommand command);
}
