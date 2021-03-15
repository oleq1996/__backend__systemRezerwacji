package codeBang.cinema.testApi.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tops")
public class Top {

    @Id
    private Integer id;
    private Integer video_id;

    public Top(Integer id, Integer video_id) {
        this.id = id;
        this.video_id = video_id;
    }

    public Top() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getVideo_id() {
        return video_id;
    }
}
