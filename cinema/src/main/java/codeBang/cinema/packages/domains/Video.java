package codeBang.cinema.packages.domains;

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
    private Integer premiereYear;
    private Integer ageRestriction;
    private Boolean subtitles;
    private Boolean dubbing;
    private String language;
    private String urlPoster;
    private String urlTrailer;

    public Video(Integer id, String title, String genre, String duration, String description, Integer premiereYear, Integer ageRestriction, Boolean subtitles, Boolean dubbing, String language, String urlPoster, String urlTrailer) {
        this.id = id;
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

    public int getPremiereYear() {
        return premiereYear;
    }

    public int getAgeRestriction() {
        return ageRestriction;
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

    public String getUrlPoster() {
        return urlPoster;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPremiereYear(Integer premiereYear) {
        this.premiereYear = premiereYear;
    }

    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setSubtitles(Boolean subtitles) {
        this.subtitles = subtitles;
    }

    public void setDubbing(Boolean dubbing) {
        this.dubbing = dubbing;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }
}
