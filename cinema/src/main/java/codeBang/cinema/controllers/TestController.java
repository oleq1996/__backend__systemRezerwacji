package codeBang.cinema.controllers;

import codeBang.cinema.domain.Test;
import codeBang.cinema.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("cinema")
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public List<Test> getAllTestData() {
        return testService.getAllTestData();
    }
}
