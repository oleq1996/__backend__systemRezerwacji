package codeBang.cinema.testApi.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="premieres")
public class Premiere {

    @Id
    private Integer id;
    private Integer video_id;
    private String start_date;

    public Premiere(Integer id, Integer video_id, String start_date) {
        this.id = id;
        this.video_id = video_id;
        this.start_date = start_date;
    }

    public Premiere() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public String getStart_date() {
        return start_date;
    }
}
