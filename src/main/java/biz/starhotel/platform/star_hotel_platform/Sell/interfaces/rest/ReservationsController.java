package biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest;


import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.queries.GetReservationById;
import biz.starhotel.platform.star_hotel_platform.Sell.domain.services.ReservationCommandService;
import biz.starhotel.platform.star_hotel_platform.Sell.domain.services.ReservationQueryService;
import biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.resources.CreateReservationResource;
import biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.resources.ReservationResource;
import biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.transform.CreateReservationCommandFromResourceAssembler;
import biz.starhotel.platform.star_hotel_platform.Sell.interfaces.rest.transform.ReservationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/reservations", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Reservations", description = "Reservations API")
public class ReservationsController {
    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    public ReservationsController(ReservationCommandService reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    @PostMapping
    public ResponseEntity<ReservationResource> createReservation(@RequestBody CreateReservationResource resource){
        System.out.println(resource);
        var createReservationCommand = CreateReservationCommandFromResourceAssembler.toCommandFromResource(resource);
        var reservationId = reservationCommandService.handle(createReservationCommand);
        if(reservationId == 0L) return ResponseEntity.badRequest().build();
        var getReservationById = new GetReservationById(reservationId);
        var reservation = reservationQueryService.handle(getReservationById);
        if(reservation.isEmpty()) return ResponseEntity.badRequest().build();
        var reservationResource = ReservationResourceFromEntityAssembler.toResourceFromEntity(reservation.get());
        return new ResponseEntity<>(reservationResource, HttpStatus.CREATED);
    }


}
