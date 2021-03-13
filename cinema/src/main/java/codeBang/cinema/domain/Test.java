package codeBang.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {

    @Id
    private String id_video;
    private String video_name;
    private int video_duration;
    private int video_price_normal;
    private int video_price_vip;
    private int video_price_double;

    public Test(){

    }
    public Test(String id_video,String video_name,int video_duration,int video_price_normal,int video_price_vip,int video_price_double){
        super();
        this.id_video=id_video;
        this.video_name=video_name;
        this.video_duration=video_duration;
        this.video_price_normal=video_price_normal;
        this.video_price_vip=video_price_vip;
        this.video_price_double=video_price_double;
    }

    public String getId_video() {
        return id_video;
    }

    public String getVideo_name() {
        return video_name;
    }

    public int getVideo_duration() {
        return video_duration;
    }

    public int getVideo_price_normal() {
        return video_price_normal;
    }

    public int getVideo_price_vip() {
        return video_price_vip;
    }

    public int getVideo_price_double() {
        return video_price_double;
    }
}
