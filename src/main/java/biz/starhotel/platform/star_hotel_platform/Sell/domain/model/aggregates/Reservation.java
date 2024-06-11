package biz.starhotel.platform.star_hotel_platform.Sell.domain.model.aggregates;

import biz.starhotel.platform.star_hotel_platform.Sell.domain.model.commands.CreateReservationCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Entity()
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer id;

    @Column(name = "guest_dni", nullable = false, length = 8)
    private String guestDni;

    @Column(name = "guest_name", nullable = false, length = 55)
    private String guestName;

    @Column(name = "guest_email", nullable = false, length = 60)
    private String guestEmail;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @Column(name = "room_name", nullable = false, length = 30)
    private String roomName;

    @Column(name = "room_type", length = 15)
    private String roomType;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "discount_percent", nullable = false, precision = 5, scale = 2)
    private BigDecimal discountPercent;

    public Reservation() {
        this.guestDni = Strings.EMPTY;
        this.guestName = Strings.EMPTY;
        this.guestEmail = Strings.EMPTY;
        this.roomId = 0;
        this.roomName = Strings.EMPTY;
        this.roomType = Strings.EMPTY;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.now();
        this.price = BigDecimal.ZERO;
        this.discountPercent = BigDecimal.ZERO;
    }

    public Reservation(String guestDni, String guestName, String guestEmail, Integer roomId, String roomName, String roomType, LocalDate startDate, LocalDate endDate, BigDecimal price, BigDecimal discountPercent) {
        this.guestDni = guestDni;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.discountPercent = discountPercent;
    }

    public Reservation(CreateReservationCommand command){
        this();
        this.guestDni = command.guestDni();
        this.guestName = command.guestName();
        this.guestEmail = command.guestEmail();
        this.roomId = command.roomId();
        this.roomName = command.roomName();
        this.roomType = command.roomType();
        this.startDate = command.startDate();
        this.endDate = command.endDate();
        this.price = command.price();
        this.discountPercent = command.discountPercent();
    }
}
