package codeBang.cinema.testApi.dto;

public class PlayingDto {

    private Integer id;
    private Integer video_id;
    private String date;
    private String time;
    private String title;
    private String genre;
    private String duration;
    private String description;
    private Integer premiere_year;
    private Integer age_restriction;
    private Boolean subtitles;
    private Boolean dubbing;
    private String language;
    private String url_poster;
    private String url_trailer;

    public PlayingDto(Integer id, Integer video_id, String date, String time, String title, String genre, String duration, String description, Integer premiere_year, Integer age_restriction, Boolean subtitles, Boolean dubbing, String language, String url_poster, String url_trailer) {
        this.id = id;
        this.video_id = video_id;
        this.date = date;
        this.time = time;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.premiere_year = premiere_year;
        this.age_restriction = age_restriction;
        this.subtitles = subtitles;
        this.dubbing = dubbing;
        this.language = language;
        this.url_poster = url_poster;
        this.url_trailer = url_trailer;
    }

}
