package codeBang.cinema.packages.dto;

import codeBang.cinema.packages.domains.Playing;
import codeBang.cinema.packages.domains.Video;

public class CombinedPlayingVideoDto {

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

    public CombinedPlayingVideoDto(Integer id, Integer videoId, String date, String time, String title, String genre, String duration, String description, Integer premiereYear, Integer ageRestriction, Boolean subtitles, Boolean dubbing, String language, String urlPoster, String urlTrailer) {
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

    public CombinedPlayingVideoDto(Playing playing, Video  video) {
        this.id = playing.getId();
        this.videoId = playing.getVideoId();
        this.date = playing.getDate().toString();
        this.time = playing.getTime().toString();
        this.title = video.getTitle();
        this.genre = video.getGenre();
        this.duration = video.getDuration();
        this.description = video.getDescription();
        this.premiereYear = video.getPremiereYear();
        this.ageRestriction = video.getAgeRestriction();
        this.subtitles = video.isSubtitles();
        this.dubbing = video.isDubbing();
        this.language = video.getLanguage();
        this.urlPoster = video.getUrlPoster();
        this.urlTrailer = video.getUrlTrailer();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPremiereYear() {
        return premiereYear;
    }

    public void setPremiereYear(Integer premiereYear) {
        this.premiereYear = premiereYear;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Boolean getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(Boolean subtitles) {
        this.subtitles = subtitles;
    }

    public Boolean getDubbing() {
        return dubbing;
    }

    public void setDubbing(Boolean dubbing) {
        this.dubbing = dubbing;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }
}
