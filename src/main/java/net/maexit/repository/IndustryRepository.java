package net.maexit.repository;

import net.maexit.entity.Industry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by arusov on 12.03.2018.
 */
public interface IndustryRepository extends MongoRepository<Industry, Integer> {

    public List<Industry> findAll();

    public Industry findAllById(int id);

    public Industry insert(Industry industry);

}
