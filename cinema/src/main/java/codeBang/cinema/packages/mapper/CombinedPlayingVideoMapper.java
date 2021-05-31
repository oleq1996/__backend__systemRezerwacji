package codeBang.cinema.packages.mapper;

import codeBang.cinema.packages.domains.Playing;
import codeBang.cinema.packages.domains.Video;
import codeBang.cinema.packages.dto.CombinedPlayingVideoDto;
import codeBang.cinema.packages.dto.PlayingDto;
import codeBang.cinema.packages.dto.VideoDto;

public class CombinedPlayingVideoMapper {

    public static CombinedPlayingVideoDto combineAndParseToDto(Playing playing, Video video){
        return new CombinedPlayingVideoDto(playing.getId(),
                playing.getVideoId(),
                playing.getDate().toString(),
                playing.getTime().toString(),
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

    public static CombinedPlayingVideoDto combineDtos (PlayingDto playingDto, VideoDto videoDto){
        return new CombinedPlayingVideoDto(playingDto.getId(),
                playingDto.getVideoId(),
                playingDto.getDate(),
                playingDto.getTime(),
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
