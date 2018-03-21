package net.maexit.repository;

import net.maexit.entity.CourseSection;
import net.maexit.entity.Lecture;
import net.maexit.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by arusov on 11.03.2018.
 */

public interface CourseSectionRepository extends MongoRepository<CourseSection, String> {

    public Optional<CourseSection> findById(String id);

    public List<CourseSection> findAll();

    public CourseSection insert(CourseSection courseSection);



}
