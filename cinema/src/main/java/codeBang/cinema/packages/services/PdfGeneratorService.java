package codeBang.cinema.packages.services;

import codeBang.cinema.packages.domains.Reservation;
import codeBang.cinema.packages.domains.Seat;
import codeBang.cinema.packages.repositories.PlayingRepository;
import codeBang.cinema.packages.repositories.SeatRepository;
import codeBang.cinema.packages.repositories.VideoRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

@Service
public class PdfGeneratorService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private PlayingRepository playingRepository;
    @Autowired
    private SeatRepository seatRepository;

    public ByteArrayInputStream generateFile(String mail, List<Reservation> reservations){
        try {
            Reservation reservationProbe = reservations.get(0);
            int id1 = reservationProbe.getPlayingId();
            int id2 = playingRepository.findById(id1).get().getVideoId();

            String title = videoRepository.findById(id2).get().getTitle();
            String date = playingRepository.findById(id1).get().getDate().toString();
            String time = playingRepository.findById(id1).get().getTime().toString();

            Document document = new Document(PageSize.A4,50,50,50,50);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);

            document.open();

            PdfContentByte cb = pdfWriter.getDirectContent();

            Font f1 = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Font f2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);

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

            PdfPTable table = new PdfPTable(2);
            table.setTotalWidth(new float[]{150,300});
            table.setLockedWidth(true);

            PdfPCell cell = new PdfPCell(p1);
            cell.setFixedHeight(20);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(2);
            table.addCell(cell);

            cell = new PdfPCell(p2);
            cell.setFixedHeight(20);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(2);
            table.addCell(cell);

            cell = new PdfPCell(p3);
            cell.setFixedHeight(30);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(2);
            table.addCell(cell);

            cell = new PdfPCell(p4);
            cell.setFixedHeight(50);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(2);
            table.addCell(cell);

            for(Reservation reservation : reservations) {

                Optional<Seat> seat = seatRepository.findById(reservation.getSeatId());

                Phrase p = new Phrase();
                p.add(new Chunk("Row: "));
                p.add(new Chunk((seat.get().getRow().toString()),f2));
                p.add(new Chunk(" Num: "));
                p.add(new Chunk(seat.get().getNumber().toString(),f2));

                cell = new PdfPCell(p);
                cell.setFixedHeight(35);
                cell.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell);

                Barcode128 barcode = new Barcode128();
                barcode.setCode(reservation.getId());
                barcode.setCodeType(Barcode128.CODE128);
                Image code128Image = barcode.createImageWithBarcode( cb,null, null);
                cell = new PdfPCell(code128Image, true);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setFixedHeight(35);
                table.addCell(cell);

            }
            document.add(table);
            document.close();

            return new ByteArrayInputStream(outputStream.toByteArray());

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
