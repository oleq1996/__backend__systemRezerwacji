package codeBang.cinema.testApi.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="videos")
public class Video {

    @Id
    private Integer id;
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

    public Video(Integer id, String title, String genre, String duration, String description, Integer premiere_year, Integer age_restriction, Boolean subtitles, Boolean dubbing, String language, String url_poster, String url_trailer) {
        this.id = id;
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

    public Video() {

    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public int getPremiere_year() {
        return premiere_year;
    }

    public int getAge_restriction() {
        return age_restriction;
    }

    public boolean isSubtitles() {
        return subtitles;
    }

    public boolean isDubbing() {
        return dubbing;
    }

    public String getLanguage() {
        return language;
    }

    public String getUrl_poster() {
        return url_poster;
    }

    public String getUrl_trailer() {
        return url_trailer;
    }
}
