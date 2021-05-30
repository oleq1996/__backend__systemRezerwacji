package codeBang.cinema.testApi.controllers;

import codeBang.cinema.testApi.domains.*;
import codeBang.cinema.testApi.dto.ReservationDto;
import codeBang.cinema.testApi.dto.SeatDto;
import codeBang.cinema.testApi.services.PdfGeneratorService;
import codeBang.cinema.testApi.services.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RequestMapping("test")
@RestController
public class TestController {

    private final VideoService videoService;
    private final SeatService seatService;
    private final ReservationService reservationService;
    private final PlayingService playingService;
    private final MailService mailService;
    private final PdfGeneratorService pdfGeneratorService;

    public TestController(VideoService videoService, SeatService seatService, ReservationService reservationService, PlayingService playingService, MailService mailService, PdfGeneratorService pdfGeneratorService) {
        this.videoService = videoService;
        this.seatService = seatService;
        this.reservationService = reservationService;
        this.playingService = playingService;
        this.mailService = mailService;
        this.pdfGeneratorService = pdfGeneratorService;
    }



    @GetMapping("/videos")
    public List<Video> getAllVideoData() {
        return videoService.getAllVideoData();
    }

    @GetMapping("/playing/")
    public List<Playing> getAllPlayingData() {
        return playingService.getAllPlayingData();
    }

    @PostMapping("/reservation")
    public ResponseEntity postNewReservation(@RequestBody List <ReservationDto> reservationDtos) throws IOException, MessagingException {
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
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }
    }

    @GetMapping("/reservation/{playingId}")
    public ResponseEntity getReservationData(@PathVariable Integer playingId){
        return new ResponseEntity<>(reservationService.getAllReservedSeats(playingId),HttpStatus.OK);
    }

    @GetMapping("/reservations")
    public ResponseEntity getReservationData(){
        return new ResponseEntity<>(reservationService.getAllReservationData(),HttpStatus.OK);
    }

//    @GetMapping(value = "/download",produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity download() {
//
//        ByteArrayInputStream inputStream = PdfGeneratorService.generateFile();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=customers.pdf");
//
//
//        return inputStream == null ?
//                new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) :
//                ResponseEntity
//                        .ok()
//                        .headers(headers)
//                        .contentType(MediaType.APPLICATION_PDF)
//                        .body(new InputStreamResource(inputStream));
//    }

}
