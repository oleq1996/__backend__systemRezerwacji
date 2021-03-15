package codeBang.cinema.testApi.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="playing")
public class Playing {

    @Id
    private Integer id;
    private Integer video_id;
    private String date;
    private String time;
    private Integer price_normal;
    private Integer price_vip;
    private Integer price_double;

    public Playing(Integer id, Integer video_id, String date, String time, Integer price_normal, Integer price_vip, Integer price_double) {
        this.id = id;
        this.video_id = video_id;
        this.date = date;
        this.time = time;
        this.price_normal = price_normal;
        this.price_vip = price_vip;
        this.price_double = price_double;
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

    public Integer getPrice_normal() {
        return price_normal;
    }

    public Integer getPrice_vip() {
        return price_vip;
    }

    public Integer getPrice_double() {
        return price_double;
    }
}
