package codeBang.cinema.packages.mapper;

import codeBang.cinema.packages.domains.Video;
import codeBang.cinema.packages.dto.VideoDto;

public class VideoMapper {

    public static VideoDto parseToDto(Video video) {
        return new VideoDto(video.getId(),
                video.getTitle(),
                video.getGenre(),
                video.getDuration(),
                video.getDescription(),
                video.getPremiereYear(),
                video.getAgeRestriction(),
                video.isSubtitles(),
                video.isDubbing(),
                video.getLanguage(),
                video.getUrlPoster(),
                video.getUrlTrailer());
    }

    public static Video parseToEntity(VideoDto videoDto){
        return new Video(videoDto.getId(),
                videoDto.getTitle(),
                videoDto.getGenre(),
                videoDto.getDuration(),
                videoDto.getDescription(),
                videoDto.getPremiereYear(),
                videoDto.getAgeRestriction(),
                videoDto.getSubtitles(),
                videoDto.getDubbing(),
                videoDto.getLanguage(),
                videoDto.getUrlPoster(),
                videoDto.getUrlTrailer());
    }
}
