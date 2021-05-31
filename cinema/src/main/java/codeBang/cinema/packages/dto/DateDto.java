package codeBang.cinema.packages.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDto {
   private String date;
   private String time;

    public DateDto() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        this.date = dateFormat.format(date);
        this.time = timeFormat.format(date);
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
