package codeBang.cinema.packages.controllers;

import codeBang.cinema.packages.domains.*;
import codeBang.cinema.packages.dto.DateDto;
import codeBang.cinema.packages.dto.ReservationDto;
import codeBang.cinema.packages.services.PdfGeneratorService;
import codeBang.cinema.packages.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayInputStream;
import java.util.List;


@RequestMapping("cinema")
@RestController
public class Rest {

    @Autowired
    private VideoService videoService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private PlayingService playingService;
    @Autowired
    private MailService mailService;
    @Autowired
    private PdfGeneratorService pdfGeneratorService;

    // DATE ENDPOINT ***

    @CrossOrigin
    @GetMapping("/date")
    public ResponseEntity getServerDate() {
        return new ResponseEntity<>(new DateDto(),HttpStatus.OK);
    }

    // VIDEOS ENDPOINTS ***

    @CrossOrigin
    @GetMapping("/videos")
    public ResponseEntity getAllVideoData() {
        return new ResponseEntity<>(videoService.getAllVideoData(),HttpStatus.OK);

    }
    @CrossOrigin
    @GetMapping("/videos/{videoId}")
    public ResponseEntity getVideoData(@PathVariable Integer videoId){
        return new ResponseEntity<>(videoService.getVideoData(videoId),HttpStatus.OK);
    }

    // PLAYING ENDPOINTS ***

    @CrossOrigin
    @GetMapping("/playing")
    public ResponseEntity getAllPlayingData() {
        return new ResponseEntity<>(playingService.getAllPlayingData(),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/playing/{date}")
    public ResponseEntity getPlayingData(@PathVariable String date) {
        return new ResponseEntity<>(playingService.getPlayingData(date),HttpStatus.OK);
    }

    // RESERVATIONS ENDPOINTS ***

    @CrossOrigin
    @GetMapping("/reservations")
    public ResponseEntity getAllReservationData(){
        return new ResponseEntity<>(reservationService.getAllReservationData(),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/reservations/{playingId}")
    public ResponseEntity getReservedSeats(@PathVariable Integer playingId){
        return new ResponseEntity<>(reservationService.getAllReservedSeats(playingId),HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/reservations",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity postNewReservation(@RequestBody List <ReservationDto> reservationDtos){
        String reservationMail = reservationService.getReservationMail(reservationDtos);

        if (!MailService.isMailValid(reservationMail)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Reservation> reservations = reservationService.postNewReservationList(reservationDtos);
            if (reservations == null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                ByteArrayInputStream inputStream = pdfGeneratorService.generateFile(reservationMail, reservations);
                mailService.sendMail(reservationMail,inputStream);

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "inline; filename=Reservation.pdf");

                return inputStream == null ?
                new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) :
                ResponseEntity
                        .ok()
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(new InputStreamResource(inputStream));
            }
        }
    }


  // SEATS ENDPOINT ***

    @CrossOrigin
    @GetMapping("/seats")
    public ResponseEntity getAllSeatsData(){
        return new ResponseEntity<>(seatService.getAllSeatData(),HttpStatus.OK);
    }

}
