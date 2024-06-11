package biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.transform;

import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.aggregates.Reservation;
import biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {
    public static ReservationResource toResourceFromEntity(Reservation entity){
        return new ReservationResource(
            entity.getId(),
            entity.getGuestDni(),
            entity.getGuestName(),
            entity.getGuestEmail(),
            entity.getRoomId(),
            entity.getRoomName(),
            entity.getRoomType(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.getPrice(),
            entity.getDiscountPercent()
        );
    }
}
