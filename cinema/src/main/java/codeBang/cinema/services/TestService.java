package codeBang.cinema.services;

import codeBang.cinema.domain.Test;
import codeBang.cinema.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<Test> getAllTestData(){
        List<Test> allTestData = new ArrayList<>();
        testRepository.findAll().forEach(allTestData::add);
        return allTestData;
    }
}
