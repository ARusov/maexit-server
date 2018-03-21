package net.maexit.repository;

import net.maexit.entity.Course;
import net.maexit.entity.Lecture;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by arusov on 11.03.2018.
 */

public interface CourseRepository extends MongoRepository<Course, String> {

    public Optional<Course> findById(String id);

    public List<Course> findAll();

    public Course insert(Course course);

    public Course save(Course course);




}
