package codeBang.cinema.testApi.services;

import codeBang.cinema.testApi.domains.Reservation;
import codeBang.cinema.testApi.dto.SeatDto;
import codeBang.cinema.testApi.repositories.PlayingRepository;
import codeBang.cinema.testApi.repositories.SeatRepository;
import codeBang.cinema.testApi.repositories.VideoRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class PdfGeneratorService {

    private VideoRepository videoRepository;
    private PlayingRepository playingRepository;
    private ReservationService reservationService;


    public PdfGeneratorService(VideoRepository videoRepository, PlayingRepository playingRepository, ReservationService reservationService) {
        this.videoRepository = videoRepository;
        this.playingRepository = playingRepository;
        this.reservationService = reservationService;
    }



    public ByteArrayInputStream generateFile(String mail, List<Reservation> reservations){
        try {
            Reservation reservationProbe = reservations.get(0);
            int id1 = reservationProbe.getPlayingId();
            int id2 = playingRepository.findById(id1).get().getVideoId();

            String title = videoRepository.findById(id2).get().getTitle();
            String date = playingRepository.findById(id1).get().getDate();
            String time = playingRepository.findById(id1).get().getTime();

            Document document = new Document(PageSize.LETTER.rotate(),50,50,50,50);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, outputStream);

            document.open();

            Font f1 = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Font f2 = FontFactory.getFont(FontFactory.COURIER_BOLD, 14, BaseColor.BLACK);

            Phrase p1 = new Phrase();
            p1.add(new Chunk("Reservation for e-mail: ",f1));
            p1.add(new Chunk(mail,f2));

            Phrase p2 = new Phrase();
            p2.add(new Chunk("Screening title: ",f1));
            p2.add(new Chunk(title,f2));

            Phrase p3 = new Phrase();
            p3.add(new Chunk("Date: ",f1));
            p3.add(new Chunk(date,f2));
            p3.add(new Chunk(" Time: ",f1));
            p3.add(new Chunk(time,f2));

            Phrase p4 = new Phrase();
            p4.add(new Chunk("Reserved seats: ",f1));

            List<SeatDto> seatDtoList = reservationService.getReservedSeats(reservations);
            com.itextpdf.text.List list = new com.itextpdf.text.List(false,10);
            com.itextpdf.text.List listPhrases = new com.itextpdf.text.List(false,10);

            for(SeatDto seatDto : seatDtoList) {
                String temp = "Row: " + seatDto.getRow().toString() + " Num: " + seatDto.getNumber().toString();
                list.add(new ListItem(temp));
            }

            listPhrases.add(new ListItem(p1));
            listPhrases.add(new ListItem(p2));
            listPhrases.add(new ListItem(p3));
            listPhrases.add(new ListItem(p4));

            document.add(listPhrases);
            document.add(list);
            document.close();

            return new ByteArrayInputStream(outputStream.toByteArray());

        }catch (Exception e){
            return null;
        }
    }
}
