package codeBang.cinema.testApi.dto;

public class PlayingDto {

    private Integer id;
    private Integer videoId;
    private String date;
    private String time;
    private String title;
    private String genre;
    private String duration;
    private String description;
    private Integer premiereYear;
    private Integer ageRestriction;
    private Boolean subtitles;
    private Boolean dubbing;
    private String language;
    private String urlPoster;
    private String urlTrailer;

    public PlayingDto(Integer id, Integer videoId, String date, String time, String title, String genre, String duration, String description, Integer premiereYear, Integer ageRestriction, Boolean subtitles, Boolean dubbing, String language, String urlPoster, String urlTrailer) {
        this.id = id;
        this.videoId = videoId;
        this.date = date;
        this.time = time;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.premiereYear = premiereYear;
        this.ageRestriction = ageRestriction;
        this.subtitles = subtitles;
        this.dubbing = dubbing;
        this.language = language;
        this.urlPoster = urlPoster;
        this.urlTrailer = urlTrailer;
    }

}
