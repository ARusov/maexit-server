package net.maexit.repository;

import net.maexit.entity.KeyValueDriver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by arusov on 11.03.2018.
 */
public interface KeyValueDriverRepository extends MongoRepository<KeyValueDriver, Integer> {

    public KeyValueDriver findById(int id);
    public List<KeyValueDriver> findAll();
    public List<KeyValueDriver> findAllByOrderByOrdering();
    public KeyValueDriver insert(KeyValueDriver keyValueDriver);

}
