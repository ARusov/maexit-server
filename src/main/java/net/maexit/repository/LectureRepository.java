package net.maexit.repository;

import net.maexit.entity.Lecture;
import net.maexit.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by arusov on 11.03.2018.
 */

public interface LectureRepository extends MongoRepository<Lecture, String> {

    public Optional<Lecture> findById(String id);

    public List<Lecture> findAll();

    public Lecture insert(Lecture lecture);



}
