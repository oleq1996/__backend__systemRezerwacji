package codeBang.cinema.testApi.services;

import codeBang.cinema.testApi.domains.Top;
import codeBang.cinema.testApi.repositories.TopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopService {

    @Autowired
    TopRepository topRepository;

    public List<Top> getAllTopData(){
        List<Top> allTopData = new ArrayList<>();
        topRepository.findAll().forEach(allTopData::add);
        return allTopData;
    }
}
