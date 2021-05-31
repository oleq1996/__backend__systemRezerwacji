package codeBang.cinema.packages.dto;

import codeBang.cinema.packages.domains.Playing;

public class PlayingDto {

    private Integer id;
    private Integer videoId;
    private String date;
    private String time;

    public PlayingDto(Integer id, Integer videoId, String date, String time) {
        this.id = id;
        this.videoId = videoId;
        this.date = date;
        this.time = time;
    }

    public PlayingDto(Playing playing) {
        this.id = playing.getId();
        this.videoId = playing.getVideoId();
        this.date = playing.getDate().toString();
        this.time = playing.getTime().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
