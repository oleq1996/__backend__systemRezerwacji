package codeBang.cinema.controllers;

import codeBang.cinema.domain.Videos;
import codeBang.cinema.services.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("cinema")
@RestController
public class CinemaRestController {
    @Autowired
    private VideosService videosService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public List<Videos> getAllTestData() {
        return videosService.getAllTestData();
    }
}
