package net.maexit.service;

import net.maexit.entity.KeyValueDriver;
import net.maexit.repository.KeyValueDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arusov on 11.03.2018.
 */
@Service
public class KeyValueDriverService {

    @Autowired
    private KeyValueDriverRepository repository;

    public KeyValueDriver findById(int id) {
        return repository.findById(id);
    }

    public List<KeyValueDriver> findAll(){
        return repository.findAll();
    }
 public List<KeyValueDriver> findAllOrOrderByOrder(){
        return repository.findAllByOrderByOrdering();
    }

    public KeyValueDriver insert (KeyValueDriver keyValueDriver){
        return repository.insert(keyValueDriver);
    }



}
