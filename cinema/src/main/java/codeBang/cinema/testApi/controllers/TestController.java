package codeBang.cinema.testApi.controllers;

import codeBang.cinema.testApi.domains.*;
import codeBang.cinema.testApi.dto.ReservationDto;
import codeBang.cinema.testApi.mapper.ReservationMapper;
import codeBang.cinema.testApi.services.*;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("test")
@RestController
public class TestController {

    private final VideoService videoService;
    private final SeatService seatService;
    private final ReservationService reservationService;
    private final PlayingService playingService;

    public TestController(VideoService videoService, SeatService seatService, ReservationService reservationService, PlayingService playingService) {
        this.videoService = videoService;
        this.seatService = seatService;
        this.reservationService = reservationService;
        this.playingService = playingService;
    }

    @GetMapping("/videos")
    public List<Video> getAllVideoData() {
        return videoService.getAllVideoData();
    }

    @GetMapping("/playing")
    public List<Playing> getAllPlayingData() {
        return playingService.getAllPlayingData();
    }

    @GetMapping("/seats")
    public List<Seat> getAllSeatData() {
        return seatService.getAllSeatData();
    }

    @PostMapping("/reservation")
    public ResponseEntity postNewReservation(@RequestBody List <ReservationDto> reservationDtoList){
        Iterable<Reservation> reservations = reservationService.postNewReservationList(reservationDtoList);
            return  reservations == null ?
                    new ResponseEntity<>(HttpStatus.CONFLICT) :
                    new ResponseEntity<>(reservations, HttpStatus.CREATED);
    }

    @GetMapping("/reservation")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservationData();
    }

}
