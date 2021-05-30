package codeBang.cinema.testApi.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



// klasy mapper



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
}
