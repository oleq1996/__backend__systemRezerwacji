package codeBang.cinema.packages.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="playing")
public class Playing {

    @Id
    private Integer id;
    private Integer videoId;
    private Date date;
    private Time time;

    public Playing(Integer id, Integer videoId, Date date, Time time) {
        this.id = id;
        this.videoId = videoId;
        this.date = date;
        this.time = time;
    }

    public Playing() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
