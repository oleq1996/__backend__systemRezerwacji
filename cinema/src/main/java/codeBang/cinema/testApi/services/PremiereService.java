package codeBang.cinema.testApi.services;

import codeBang.cinema.testApi.domains.Premiere;
import codeBang.cinema.testApi.repositories.PremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PremiereService {

    @Autowired
    PremiereRepository premiereRepository;

    public List<Premiere> getAllPremiereData(){
        List<Premiere> allPremiereData = new ArrayList<>();
        premiereRepository.findAll().forEach(allPremiereData::add);
        return allPremiereData;
    }
}
