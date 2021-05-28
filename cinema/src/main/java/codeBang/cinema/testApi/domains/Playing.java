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
    private Integer video_id;
    private String date;
    private String time;

    public Playing(Integer id, Integer video_id, String date, String time) {
        this.id = id;
        this.video_id = video_id;
        this.date = date;
        this.time = time;
    }

    public Playing() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
