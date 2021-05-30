package codeBang.cinema.packages.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="playing")
public class Playing {

    @Id
    private Integer id;
    private Integer videoId;
    private String date;
    private String time;

    public Playing(Integer id, Integer videoId, String date, String time) {
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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
