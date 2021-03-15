package codeBang.cinema.testApi.controllers;

import codeBang.cinema.testApi.domains.*;
import codeBang.cinema.testApi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    VideoService videoService;
    @Autowired
    TopService topService;
    @Autowired
    SeatService seatService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    PremiereService premiereService;
    @Autowired
    PlayingService playingService;

    @GetMapping("/videos")
    public List<Video> getAllVideosData() {
        return videoService.getAllVideoData();
    }

    @GetMapping("/tops")
    public List<Top> getAllTopsData() {
        return topService.getAllTopData();
    }

    @GetMapping("/seats")
    public List<Seat> getAllSeatData() {
        return seatService.getAllSeatData();
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservationData() {
        return reservationService.getAllReservationData();
    }

    @PostMapping("/reservations")
    public Iterable<Reservation> putNewReservation(@RequestBody List <Reservation> reservationList){
        return reservationService.putNewReservationList(reservationList);
    }

    @GetMapping("/premieres")
    public List<Premiere> getAllPremiereData() {
        return premiereService.getAllPremiereData();
    }

    @GetMapping("/playing")
    public List<Playing> getAllPlayingData() {
        return playingService.getAllPlayingData();
    }

}
