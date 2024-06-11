package biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.transform;

import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.commands.CreateReservationCommand;
import biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.resources.CreateReservationResource;

public class CreateReservationCommandFromResourceAssembler {
    public static CreateReservationCommand toCommandFromResource(CreateReservationResource resource){
        return new CreateReservationCommand(
            resource.guestDni(),
            resource.guestName(),
            resource.guestEmail(),
            resource.roomId(),
            resource.roomName(),
            resource.roomType(),
            resource.startDate(),
            resource.endDate(),
            resource.price(),
            resource.discountPercent()
        );
    }
}
