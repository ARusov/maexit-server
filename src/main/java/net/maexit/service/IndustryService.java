package net.maexit.service;

import net.maexit.entity.Industry;
import net.maexit.repository.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arusov on 12.03.2018.
 */
@Service
public class IndustryService {

    @Autowired
    private IndustryRepository repository;


    public List<Industry> findAll() {
       return repository.findAll();
    }

    public Industry findAllById(int id) {
        return repository.findAllById(id);
    }

    public Industry insert(Industry industry) {
        return repository.insert(industry);
    }

}
